package com.axiomalaska.crks.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axiomalaska.crks.exception.MissingRequiredParameterException;
import com.axiomalaska.crks.service.WfsProxy;
import com.axiomalaska.crks.service.result.WfsResult;

public class WfsResultServlet extends HttpServlet {

	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    ServletContext sc = getServletContext();
	    ServletOutputStream op = resp.getOutputStream();
	    String wfsUrl = req.getParameter("url");
	    String layerNamesStr = req.getParameter("layerNames");
	    String datePropertiesStr = req.getParameter("dateProperties");	    
	    String outputFormat = req.getParameter("outputFormat");
	    String swLngStr = req.getParameter("swLng");
	    String swLatStr = req.getParameter("swLat");
	    String neLngStr = req.getParameter("neLng");
	    String neLatStr = req.getParameter("neLat");	   
	    String startDateStr = req.getParameter("startDate");
	    String endDateStr = req.getParameter("endDate");
	    
	    Date startDate = null;
	    Date endDate = null;
	    	    
	    if( startDateStr != null && startDateStr.trim().length() > 0 ){
		    try {
				startDate = WfsProxy.ISO_8061_FORMAT.parse( startDateStr.trim() );
			} catch (ParseException e) {
				PrintWriter writer = resp.getWriter();
				writer.write("startDate must be a valid ISO8061 date");
				return;
			}
	    }
	    
	    if( endDateStr != null && endDateStr.trim().length() > 0 ){
		    try {
				endDate = WfsProxy.ISO_8061_FORMAT.parse( endDateStr.trim() );
			} catch (ParseException e) {
				PrintWriter writer = resp.getWriter();
				writer.write("endDate must be a valid ISO8061 date");
				return;
			}
	    }

	    try {
	    	requireParam( "url", wfsUrl );
		} catch (MissingRequiredParameterException e) {
			PrintWriter writer = resp.getWriter();
			writer.write("url parameter is required");
			e.printStackTrace();
		}

	    try {
	    	requireParam( "layerNames", wfsUrl );
		} catch (MissingRequiredParameterException e) {
			PrintWriter writer = resp.getWriter();
			writer.write("layerNames parameter is required");
			e.printStackTrace();
		}

	    try {
	    	requireParam( "dateProperties", wfsUrl );
		} catch (MissingRequiredParameterException e) {
			PrintWriter writer = resp.getWriter();
			writer.write("dateProperties parameter is required");
			e.printStackTrace();
		}

	    try {
	    	requireParam( "swLng", swLngStr );
		} catch (MissingRequiredParameterException e) {
			PrintWriter writer = resp.getWriter();
			writer.write("swLng parameter is required");
			e.printStackTrace();
		}

	    try {
	    	requireParam( "swLat", swLatStr );
		} catch (MissingRequiredParameterException e) {
			PrintWriter writer = resp.getWriter();
			writer.write("swLat parameter is required");
			e.printStackTrace();
		}
	    
	    try {
	    	requireParam( "neLng", neLngStr );
		} catch (MissingRequiredParameterException e) {
			PrintWriter writer = resp.getWriter();
			writer.write("neLng parameter is required");
			e.printStackTrace();
		}
	    
	    try {
	    	requireParam( "neLat", neLatStr );
		} catch (MissingRequiredParameterException e) {
			PrintWriter writer = resp.getWriter();
			writer.write("neLngStr parameter is required");
			e.printStackTrace();
		}
	    
	    double swLng = Double.parseDouble( swLngStr );
	    double swLat = Double.parseDouble( swLatStr );
	    double neLng = Double.parseDouble( neLngStr );
	    double neLat = Double.parseDouble( neLatStr );
	    
	    if( outputFormat == null ){
	    	outputFormat = WfsProxy.OUTPUT_FORMAT.CSV;
	    }
	    
	    List<String> layerNames = Arrays.asList( layerNamesStr.split(",") );
	    List<String> dateProperties = Arrays.asList( datePropertiesStr.split(",") );
	    int len = dateProperties.size();
	    for( int i = 0; i < len; i++ ){
	    	if( dateProperties.get(i).equals("NODATE") ){
	    		dateProperties.set(i, null);
	    	}
	    }
	    
		WfsResult result = WfsProxy.getFeatures( wfsUrl, layerNames, dateProperties,
			outputFormat, swLng, swLat, neLng, neLat, startDate, endDate );
	    
		String fullFilename = result.getFilename() + "." + result.getExt();
		
		resp.setContentType( result.getContentType() );
		resp.setContentLength( result.getContentLength() );
		resp.setCharacterEncoding( resp.getCharacterEncoding() );
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + fullFilename + "\"");		
		op.write( result.getBytes() );
		op.flush();
		op.close();
	}
	
	private void requireParam( String paramName, Object param ) throws MissingRequiredParameterException{
		boolean paramPresent = true;
		if( param == null ) paramPresent = false;
		if( param instanceof String ){
			String str = (String) param;
			if( str.trim().length() == 0 ) paramPresent = false;
		}
		
		if( !paramPresent ){
			throw new MissingRequiredParameterException( paramName );
		}
	}
}
