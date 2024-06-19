package com.ttn.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(
        service = {Servlet.class},
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + "/bin/training/example",
                "sling.servlet.extensions=" + "html"
        }
)
public class ServletExample extends SlingAllMethodsServlet {

    @Override
    protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws ServletException, IOException {
   //     super.doPost(req, resp);
        resp.setContentType("text/html");
        resp.getWriter().write(" this is my new servlet");

    }

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        resp.getWriter().write("This is my first servlet.  ");
    }
}
