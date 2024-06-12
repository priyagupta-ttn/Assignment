##### Create a OSGI configuration service and include one string variable. This variable should have the value for author environment as " This servlet is executed from author environment" and for publisher the value of the variable should be " This servlet is executed from publisher environment". Use this configuration service in the above servlet and read the value fron configuration service and print this value as servlet output. When we execute the servlet on author and publisher it should print output as configured.
-> step 1: create a OsgiConfigurationService interface

~~~~~~
package com.ttn.demo.core.service;

public interface OsgiConfigurationService {
String getEnvironmentMessage();
}
~~~~~~

-> step 2  create OsgiConfigurationServiceImpl 

~~~~~~
package com.ttn.demo.core.service.impl;

import com.ttn.demo.core.service.OsgiConfigurationService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component( service = OsgiConfigurationServiceImpl.class, immediate = true)
@Designate(ocd = OsgiConfigurationServiceImpl.OsgiConfiguration.class)
public class OsgiConfigurationServiceImpl implements OsgiConfigurationService {

    String environmentMessage;

    @ObjectClassDefinition(name = "Osgi Configurations for Environment",
            description = "Osgi configuration")
    public @interface OsgiConfiguration {

        @AttributeDefinition(name = "Environment message", required = true,

                description = "Message to be displayed based on the environment",
                type = AttributeType.INTEGER)
        String environment_message() default  "This is default message";
    }

    @Activate
    public void activate(OsgiConfigurationServiceImpl.OsgiConfiguration config) {

        environmentMessage = config.environment_message();

    }

    @Override
    public String getEnvironmentMessage() {
        return environmentMessage;
    }

}
~~~~~~
Step 3  - call service inside servlet
~~~~~~


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
~~~~~~

Step 4 Step 5 create a config json file under ui.config/**/config.author path with name + + ~ + + cfg.json 
e.g com.ttn.demo.core.service.impl.OsgiConfigurationServiceImpl~ttndemo.cfg.json in out case with the below json

~~~~
{
"environment.message" : "This servlet is executed from author environment"
}
~~~~



