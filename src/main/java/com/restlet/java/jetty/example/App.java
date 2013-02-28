package com.restlet.java.jetty.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main(String[] args) throws Exception
    {
    	int port = 8080;
    	String sysport;
    	if ((sysport = System.getenv("PORT")) != null){
    		port = Integer.parseInt(sysport);
    	}
        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloWorldResource()),"/*");
        server.start();
        server.join();
    }
}