package com.server;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Server {

    public static void main(String[] args) throws LifecycleException,
            InterruptedException, ServletException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8083);
        
        tomcat.setConnector(tomcat.getConnector());

        Context ctx = tomcat.addContext("", null);

        
        Tomcat.addServlet(ctx, "Embedded", new CallbackServlet()).setMultipartConfigElement(new MultipartConfigElement(""));
        

        ctx.addServletMappingDecoded("/*", "Embedded");

        tomcat.start();
        tomcat.getServer().await();
    }
}