package com.example.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TomcatMain {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8088);

        // 创建Servlet
        HttpServlet servlet = new MyServlet();

        // 创建Servlet容器，并添加Servlet
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context, "MyServlet", servlet);
        context.addServletMappingDecoded("/myservlet", "MyServlet");

        tomcat.start();
        tomcat.getServer().await();
    }

    private static class MyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.getWriter().println("Hello, world!");
        }
    }
}
