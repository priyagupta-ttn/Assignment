package com.ttn.demo.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component(service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "/ttndemo/components/resourceservlet",
        methods = HttpConstants.METHOD_GET,
        extensions = "txt")
public class ResourceServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        List<String> subjects = Arrays.asList("Java","AEM","MYSQL");


        resp.setContentType("text/html");
        resp.getWriter().write(  "Subjects List" + subjects);
    }
}
