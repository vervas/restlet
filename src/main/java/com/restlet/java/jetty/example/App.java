package com.restlet.java.jetty.example;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.servlet.Context;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class App {

	public static void main(String[] args) throws Exception {
		int port = 8080;
		String sysport;
		if ((sysport = System.getenv("PORT")) != null) {
			port = Integer.parseInt(sysport);
		}

		ServletHolder sh = new ServletHolder(ServletContainer.class);

		sh.setInitParameter(
				"com.sun.jersey.config.property.resourceConfigClass",
				"com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter(
				"com.sun.jersey.config.property.packages",
				"com.restlet.java.jetty.example");

		Server server = new Server(port);
		Context context = new Context(server, "/", Context.SESSIONS);

		context.addServlet(sh, "/*");
		server.start();
		server.join();
	}
}