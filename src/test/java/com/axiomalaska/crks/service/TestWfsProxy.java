
package com.axiomalaska.crks.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.dom4j.DocumentException;

import com.axiomalaska.crks.service.result.WfsResult;

public class TestWfsProxy extends TestCase {
    private static String wfsUrl = "http://192.168.1.199/geoserver/wfs";
    private static double swLng = -150;
    private static double swLat =  60;
	private static double neLng = -149.5;
	private static double neLat =  60.5;
	private static Date startDate; 
	private static Date endDate;
	private static List<String> layerNames;
	private static List<String> dateProperties;

    public void setUp(){
		Calendar cal = Calendar.getInstance();
		cal.set( Calendar.YEAR, 1970 );
		cal.set( Calendar.MONTH, 0 );
		cal.set( Calendar.DATE, 1 );		
		startDate = cal.getTime();
		
		cal.set( Calendar.YEAR, 2010 );
		cal.set( Calendar.MONTH, 0 );
		cal.set( Calendar.DATE, 1 );		
		endDate = cal.getTime();
		
		layerNames = new ArrayList<String>();
		layerNames.add("crks:AlaskaCommunities");
		
		dateProperties = new ArrayList<String>();
		dateProperties.add( null );		
    }
    
    public static void testWfsProxyCount() throws IOException, DocumentException{
		int featureCount = WfsProxy.getFeatureCount(wfsUrl, layerNames, dateProperties,
			swLng, swLat, neLng, neLat, startDate, endDate);		
    	assertTrue( featureCount > 0 );
    }
   
    public static void testWfsProxyShapezip() throws IOException, DocumentException{    	
    	WfsResult result = WfsProxy.getFeatures( wfsUrl, layerNames, dateProperties,
    		WfsProxy.OUTPUT_FORMAT.SHAPEZIP, swLng, swLat, neLng, neLat, startDate, endDate );
    	
    	assertTrue( result.getContentType().equals( WfsProxy.RESULT_TYPE.ZIP ) );
    	assertTrue( result.getBytes().length > 0 );
    }

    public static void testWfsProxyExcel() throws IOException, DocumentException{    	
    	WfsResult result = WfsProxy.getFeatures( wfsUrl, layerNames, dateProperties,
    		WfsProxy.OUTPUT_FORMAT.EXCEL, swLng, swLat, neLng, neLat, startDate, endDate );
    	
    	assertTrue( result.getContentType().equals( WfsProxy.RESULT_TYPE.EXCEL ) );
    	assertTrue( result.getBytes().length > 0 );
    }

    public static void testWfsProxyCsv() throws IOException, DocumentException{    	
    	WfsResult result = WfsProxy.getFeatures( wfsUrl, layerNames, dateProperties,
    		WfsProxy.OUTPUT_FORMAT.CSV, swLng, swLat, neLng, neLat, startDate, endDate );
    	
    	assertTrue( result.getContentType().equals( WfsProxy.RESULT_TYPE.CSV ) );
    	assertTrue( result.getBytes().length > 0 );
    }
    public static void testFakeTest(){
    	assertTrue( true ); //amazing
    }
}

