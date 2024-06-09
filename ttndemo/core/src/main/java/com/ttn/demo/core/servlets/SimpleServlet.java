package com.ttn.demo.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;

import com.ttn.demo.core.beans.Student;
import com.ttn.demo.core.service.MySimpleService;
import com.ttn.demo.core.service.StudentClassService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link org.apache.sling.api.servlets.SlingAllMethodsServlet}.
 */
@Component(service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "ttndemo/components/page",
        methods = HttpConstants.METHOD_GET,
        extensions = "txt")
@ServiceDescription("Simple Demo Servlet")
public class SimpleServlet extends SlingSafeMethodsServlet {

    @Reference
    private MySimpleService mySimpleService;

    @Reference
    private StudentClassService studentClassService;

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(SimpleServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
            throws ServletException, IOException {
        mySimpleService.fetchURL();

        Student student = new Student("1", "John Doe", 75, 20);
        studentClassService.addStudent(student);

        // Print all students
        for (Student s : studentClassService.getAllStudents()) {
            log.info("ID: {}, Name: {}, Marks: {}, Age: {}", s.getId(), s.getName(), s.getMarks(), s.getAge());
        }

        // Check if student passed
        log.info("Student passed: {}", studentClassService.isStudentPassed("1"));

        final Resource resource = req.getResource();
        resp.setContentType("text/plain");
        String title = resource.getValueMap().get(JcrConstants.JCR_TITLE, String.class);
        resp.getWriter().write("Title = " + (title != null ? title : "No title found"));
    }
}
