package com.axiomalaska.crks.service;

import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class ContextListener implements ServletContextListener {
	private ServletContext context = null;

	public ContextListener() {}

	public void contextInitialized(ServletContextEvent event){
		this.context = event.getServletContext();
		TimeZone.setDefault( TimeZone.getTimeZone("UTC") );
	}

	public void contextDestroyed(ServletContextEvent event){
	    this.context = null;
	}

}