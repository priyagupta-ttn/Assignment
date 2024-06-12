package com.ttn.demo.core.servlets;


import com.ttn.demo.core.service.OsgiConfigurationService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(
        service = {Servlet.class},
        property = {
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/training/configtest",
                "sling.servlet.extensions=" + "html"
        }
)
public class ConfigTestServlet extends SlingSafeMethodsServlet {

    @Reference
    OsgiConfigurationService osgiConfigurationService;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        resp.getWriter().write("This is my first servlet.  " + osgiConfigurationService.getEnvironmentMessage());
    }
}


