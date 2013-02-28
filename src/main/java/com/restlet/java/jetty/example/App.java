package com.restlet.java.jetty.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

/**
 * Hello world!
 *
 */
public class App extends HttpServlet
{

    private static final long serialVersionUID = -1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("Hello world");
        out.flush();
        out.close();
    }

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
        context.addServlet(new ServletHolder(new App()),"/*");
        server.start();
        server.join();
    }
}