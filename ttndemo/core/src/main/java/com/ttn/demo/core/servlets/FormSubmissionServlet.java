package com.ttn.demo.core.servlets;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.framework.Constants;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(
        service = { Servlet.class },
        property = {
                Constants.SERVICE_DESCRIPTION + "=Simple Servlet Example",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET + "," + HttpConstants.METHOD_POST,
                "sling.servlet.paths=" + "/bin/contactformsubmit"
        }
)
public class FormSubmissionServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

//    @Override
//    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {
//        try {
//            String body = IOUtils.toString(request.getReader());
//
//            ResourceResolver resolver = request.getResourceResolver();
//            Resource resource = resolver.getResource("/content/my-test/jcr:content");
//            if (resource != null) {
//
//                try {
//                    JSONObject json = new JSONObject(body);
//                    String fname = json.optString("fname");
//                    String lname = json.optString("lname");
//                    String email = json.optString("email");
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
////                String fname = request.getParameter("fname");
////                String lname = request.getParameter("lname");
////                String email = request.getParameter("email");
//                ModifiableValueMap properties = resource.adaptTo(ModifiableValueMap.class);
//                properties.put("firstName", fname);
//                properties.put("lastName", lname);
//                properties.put("email", email);
//
//                resolver.commit();
//                response.getWriter().println("Successfully set form details");
//            } else {
//                response.getWriter().println("Node /content/my-test not found.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            String body = IOUtils.toString(request.getReader());
            JSONObject json = new JSONObject(body);

            String fname = json.optString("fname");
            String lname = json.optString("lname");
            String email = json.optString("email");

            ResourceResolver resolver = request.getResourceResolver();
            Resource resource = resolver.getResource("/content/my-test/jcr:content");

            if (resource != null) {
                ModifiableValueMap properties = resource.adaptTo(ModifiableValueMap.class);
                if (properties != null) {
                    properties.put("firstName", fname);
                    properties.put("lastName", lname);
                    properties.put("email", email);

                    resolver.commit();
                    response.getWriter().println("Successfully set form details");
                } else {
                    response.getWriter().println("Could not adapt resource to ModifiableValueMap");
                }
            } else {
                response.getWriter().println("Node /content/my-test not found.");
            }
        } catch (JSONException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Invalid JSON");
            e.printStackTrace();
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error reading request body");
            e.printStackTrace();
        }
    }

}
