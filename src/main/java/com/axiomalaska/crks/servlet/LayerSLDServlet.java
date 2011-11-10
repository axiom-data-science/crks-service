package com.axiomalaska.crks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axiomalaska.crks.service.CrksService;

public class LayerSLDServlet extends HttpServlet {

	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    // Get the absolute path of the image
	    ServletContext sc = getServletContext();
	    int id = Integer.parseInt( req.getParameter("id") );

	    PrintWriter out = resp.getWriter();
	    resp.setContentType("text/xml");
	    out.println("<?xml version=\"1.0\"?>");
        out.write( CrksService.getLayerSLD( id ) );
        out.flush();
	    out.close();
	}
}
