### Assignment 3

#### Question 1 Create service ClassConfigurationService that allows two configuration :

No. of students allowed in the class

marks required by the student to pass the class

also it exposes two methods :

isClassLimitReached(List) // returns true if the list size is less than the configured allowed size

getPassingMarks() // returns the passing marks required

Create another service StudentClassService that maintains the list of students in the class and make use of
ClassConfigurationService and exposes the following methods :

addStudent(student values)

deleteStudent(id)

isStudentPassed(id)

getStudent(id)

getAllStudents()

A student may have id,name , marks obtained,age etc

Access the service and print a students information.

### Solution -
Added Code in TTN Demo project. Code is added in gitthub repository

ClassConfigurationService

ClassConfigurationServiceImpl

StudentClassService

StudentClassServiceImpl

SimpleServlet


#### Question 2  Create a servlet and register it on path /bin/training/configtest and extension as html, method as GET. It should print the hardcoded message "This is my first servlet."

### Answer 

package com.ttn.demo.core.servlets;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

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

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("This is my first servlet.");
    }
}


Accessing localhost"5502/bin/training/configtest  gives desired output.

#### Question 3 Create a OSGI configuration service and include one string variable. This variable should have the value for author environment as " This servlet is executed from author environment" and for publisher the value of the variable should be " This servlet is executed from publisher environment". Use this configuration service in the above servlet and read the value fron configuration service and print this value as servlet output. When we execute the servlet on author and publisher it should print output as configured.

#### Answer
Added code in TTN demo project .

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



