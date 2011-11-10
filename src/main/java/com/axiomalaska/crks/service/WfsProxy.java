package com.axiomalaska.crks.service;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.axiomalaska.crks.service.result.WfsResult;

public class WfsProxy {
    static {
    	TimeZone.setDefault( TimeZone.getTimeZone("UTC") );
    }	
	
    @SuppressWarnings("unused")
	private static Logger log = Logger.getLogger( WfsProxy.class );    
    
    private static final Namespace TOPP_NAMESPACE = new Namespace("topp", "http://www.openplans.org/topp");	
    private static final Namespace GML_NAMESPACE = new Namespace("gml", "http://www.opengis.net/gml");
    private static final Namespace WFS_NAMESPACE = new Namespace( "wfs", "http://www.opengis.net/wfs");
    private static final Namespace OGC_NAMESPACE = new Namespace( "ogc", "http://www.opengis.net/ogc");
    private static final Namespace XSI_NAMESPACE = new Namespace( "xsi", "http://www.w3.org/2001/XMLSchema-instance");

    private static final String WFS_SCHEMA_1_1_1 = "http://www.opengis.net/wfs http://schemas.opengis.net/wfs/1.1.0/wfs.xsd";
    private static final String WFS_SCHEMA_1_0_0 = "http://www.opengis.net/wfs http://schemas.opengis.net/wfs/1.0.0/WFS-basic.xsd";

    private static final String WFS_1_1_1 = "1.1.1";
    private static final String WFS_1_0_0 = "1.0.0";
    public static final SimpleDateFormat ISO_8061_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	public static final class OUTPUT_FORMAT {
		public static final String CSV = "csv";
		public static final String SHAPEZIP = "shape-zip";
		public static final String EXCEL = "excel";
	}

	public static final class RESULT_TYPE {
		public static final String APPLICATION_XML = "application/xml";
		public static final String XML = "text/xml";
		public static final String EXCEL = "application/msexcel";
		public static final String ZIP = "application/zip";
		public static final String CSV = "text/csv";	
		public static final String TEXT = "text/plain";
		public static final String XML_UTF8 = "text/xml;charset=UTF-8";		
	}

	public static final class RESULT_TYPE_EXT {
		public static final String APPLICATION_XML = "xml";
		public static final String XML = "xml";
		public static final String EXCEL = "xls";
		public static final String ZIP = "zip";
		public static final String CSV = "csv";	
		public static final String TEXT = "txt";
		public static final String XML_UTF8 = "xml";
	}

    private static final SAXReader SAX_READER = new SAXReader();

	private static final XMLWriter XML_CONSOLE_WRITER = getXmlScreenWriter();
	
	private static XMLWriter getXmlScreenWriter(){
		Console console = System.console();		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlScreenWriter = null;
		try {
			xmlScreenWriter = new XMLWriter(System.out, format);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return xmlScreenWriter;
	}

	private static ByteArrayOutputStream inputStreamToByteArrayOutputStream( InputStream is ) throws IOException{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		
		int nRead;
		byte[] data = new byte[16384];
		
		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		
		buffer.flush();
		return buffer;
	}

	private static Document buildGetFeatureXml( String wfsVersion, List<String> layerNames, List<String> dateProperties, String outputFormat,
		double swLng, double swLat, double neLng, double neLat, Date startDate, Date endDate, boolean countOnly
	){
		Document getFeatureDoc = DocumentHelper.createDocument();

        Element getFeature = getFeatureDoc.addElement( QName.get( "GetFeature", WFS_NAMESPACE ) );
        getFeature.add( TOPP_NAMESPACE );
        getFeature.add( GML_NAMESPACE );
        getFeature.add( WFS_NAMESPACE );
        getFeature.add( OGC_NAMESPACE );
        getFeature.add( XSI_NAMESPACE );
        if( wfsVersion.equals( WFS_1_1_1 ) ){
        	getFeature.addAttribute( QName.get("schemaLocation", XSI_NAMESPACE ), WFS_SCHEMA_1_1_1 );
        } else {
        	getFeature.addAttribute( QName.get("schemaLocation", XSI_NAMESPACE ), WFS_SCHEMA_1_0_0 );
        };

        getFeature.addAttribute( "service", "WFS" );
		getFeature.addAttribute( "version", wfsVersion );
		if( countOnly ){
			getFeature.addAttribute( "resultType", "hits" );
		} else {
			getFeature.addAttribute( "outputFormat", outputFormat );
		}
				
		int numLayers = layerNames.size();
		for( int i = 0; i < numLayers; i++ ){
			String layerName = layerNames.get( i );
			String dateProperty = dateProperties.get( i );

			Element query = getFeature.addElement( QName.get( "Query", WFS_NAMESPACE ) );
			query.addAttribute( "typeName", layerName );
			
			Element filter = query.addElement( QName.get( "Filter", OGC_NAMESPACE ) );
			Element andFilter = filter.addElement( QName.get( "And", OGC_NAMESPACE ) );
			Element notFilter = andFilter.addElement( QName.get( "Not", OGC_NAMESPACE ) );
			Element disjointFilter = notFilter.addElement( QName.get( "Disjoint", OGC_NAMESPACE ) );
			disjointFilter.addElement( QName.get( "PropertyName", OGC_NAMESPACE ) );
			
			if( wfsVersion.equals( WFS_1_1_1 ) ){
				Element envelope = disjointFilter.addElement( QName.get( "Envelope", GML_NAMESPACE ) );
				envelope.addAttribute( "srsName", "EPSG:4326" );
				
				Element lowerCorner = envelope.addElement( QName.get( "lowerCorner", GML_NAMESPACE ) );
				lowerCorner.addText( swLng + " " + swLat );

				Element upperCorner = envelope.addElement( QName.get( "upperCorner", GML_NAMESPACE ) );
				upperCorner.addText( neLng + " " + neLat );			
			} else {
				Element box = disjointFilter.addElement( QName.get( "Box", GML_NAMESPACE ) );
				box.addAttribute( "srsName", "EPSG:4326" );

				Element coordinates = box.addElement( QName.get( "coordinates", GML_NAMESPACE ) );
				coordinates.addText( swLng + "," + swLat + " " + neLng + "," + neLat );			
			}

			if( startDate != null && endDate != null && dateProperty != null && dateProperty.length() > 0 ){
				 Element propertyIsBetween = andFilter.addElement( QName.get( "PropertyIsBetween", OGC_NAMESPACE ) );
				 
				 Element propertyName = propertyIsBetween.addElement( QName.get( "PropertyName", OGC_NAMESPACE ) );
				 propertyName.addText( dateProperty );
				 
				 Element lowerBoundary = propertyIsBetween.addElement( QName.get( "LowerBoundary", OGC_NAMESPACE ) );
				 lowerBoundary.addElement( QName.get( "Literal", OGC_NAMESPACE ) ).addText( ISO_8061_FORMAT.format( startDate ) );

				 Element upperBoundary = propertyIsBetween.addElement( QName.get( "UpperBoundary", OGC_NAMESPACE ) );
				 upperBoundary.addElement( QName.get( "Literal", OGC_NAMESPACE ) ).addText( ISO_8061_FORMAT.format( endDate ) );
	 		}
		}
 		
 		return getFeatureDoc;
	}

	public static int getFeatureCount( String wfsUrl, List<String> layerNames, List<String> dateProperties,
			double swLng, double swLat, double neLng, double neLat, Date startDate, Date endDate
	) throws IOException, DocumentException{
		int featureCount = -1;
		
		Document getFeatureDoc = buildGetFeatureXml( WFS_1_1_1, layerNames, dateProperties, null,
			swLng, swLat, neLng, neLat, startDate, endDate, true );				
		
		HttpURLConnection conn = getResponse( wfsUrl, getFeatureDoc );
		String responseContentType = conn.getContentType();
		
		if( responseContentType.equals( RESULT_TYPE.XML ) ){
			Document resultDoc = SAX_READER.read( conn.getInputStream() );
// 			XML_CONSOLE_WRITER.write( resultDoc );
			featureCount = Integer.parseInt( resultDoc.getRootElement().attribute("numberOfFeatures").getValue() );
		}		
		
		return featureCount; 		
	}
	
	public static WfsResult getFeatures( String wfsUrl, List<String> layerNames, List<String> dateProperties, String outputFormat,
		double swLng, double swLat, double neLng, double neLat, Date startDate, Date endDate
	) throws IOException{
		if( outputFormat == null ){
			outputFormat = OUTPUT_FORMAT.CSV;
		}

		String wfsVersion = WFS_1_1_1;
		if( outputFormat.equals( OUTPUT_FORMAT.SHAPEZIP ) ){
			wfsVersion = WFS_1_0_0;
		}

		Document getFeatureDoc = buildGetFeatureXml( wfsVersion, layerNames, dateProperties, outputFormat,
			swLng, swLat, neLng, neLat, startDate, endDate, false );

		HttpURLConnection conn = getResponse( wfsUrl, getFeatureDoc );
		String responseContentType = conn.getContentType();

		WfsResult result = new WfsResult();
		result.setFilename("wfs_query_result");

		if( responseContentType.equals( RESULT_TYPE.CSV ) ){
			result.setExt( RESULT_TYPE_EXT.CSV );
		} else if( responseContentType.equals( RESULT_TYPE.EXCEL ) ){
			result.setExt( RESULT_TYPE_EXT.EXCEL );
		} else if( responseContentType.equals( RESULT_TYPE.TEXT ) ){
			result.setExt( RESULT_TYPE_EXT.TEXT );
		} else if( responseContentType.equals( RESULT_TYPE.XML ) ){
			result.setExt( RESULT_TYPE_EXT.XML );
		} else if( responseContentType.equals( RESULT_TYPE.XML_UTF8 ) ){
			result.setExt( RESULT_TYPE_EXT.XML_UTF8 );
		} else if( responseContentType.equals( RESULT_TYPE.ZIP ) ){
			result.setExt( RESULT_TYPE_EXT.ZIP );
		} else if( responseContentType.equals( RESULT_TYPE.TEXT ) ){
			result.setExt( RESULT_TYPE_EXT.TEXT );
		} else if( responseContentType.equals( RESULT_TYPE.APPLICATION_XML ) ){
			result.setFilename("wfs_error");
			result.setExt( RESULT_TYPE_EXT.APPLICATION_XML );
		} else {
			result.setExt( "unknown" );
		}

		result.setContentEncoding( conn.getContentEncoding() );
		result.setContentLength( conn.getContentLength() );
		result.setContentType( responseContentType );
		ByteArrayOutputStream os = inputStreamToByteArrayOutputStream( conn.getInputStream() );
		result.setBytes( os.toByteArray() );

		return result;
	}
		
	private static HttpURLConnection getResponse( String wfsUrl, Document xmlRequest ) throws IOException{
//		XML_CONSOLE_WRITER.write( xmlRequest );

		URL url = new URL( wfsUrl );
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setConnectTimeout( 0 );
		conn.setReadTimeout( 0 );
		conn.setUseCaches(false);
		conn.setDefaultUseCaches(false);
		conn.setRequestMethod("POST");		
		conn.setRequestProperty( "Content-Type", "text/xml" );

		XMLWriter xmlOutputStreamWriter = new XMLWriter( conn.getOutputStream() );
		xmlOutputStreamWriter.write( xmlRequest );
		xmlOutputStreamWriter.flush();
		xmlOutputStreamWriter.close();		
		
		return conn;		
	}
}