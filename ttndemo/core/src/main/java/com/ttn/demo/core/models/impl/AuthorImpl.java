package com.ttn.demo.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ttn.demo.core.models.Author;
import com.ttn.demo.core.service.MySimpleService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Author.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorImpl implements Author {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorImpl.class);

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;
    @ScriptVariable
    Page currentPage;

    @OSGiService(filter = "(component.name=serviceDemoImpl)")
    private MySimpleService mySimpleService;

    @RequestAttribute(name = "rAttribute")
    private String reqAttribute;

    @ResourcePath(path="apps/ttndemo/components/helloworld")@Via("resource")
    Resource resourcePage;

    @Inject
    @Via("resource")
    @Named("jcr:lastModifiedBy")
    String modifiedBy;

    private String message;

    @PostConstruct
    protected void init() {
        message = "Initialising from Bootcamp PostConstruct.";
    }

    @Inject
    @Via("resource")
    @Default(values = "AEM")
    String fname;

//    @Inject
//    @Required
//    @Via("resource")
    @ValueMapValue
    @Default(values = "Geeks")
    String lname;

    @Inject
    @Via("resource")
    boolean professor;


    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return false;
    }

    @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }

    @Override
    @JsonIgnore
    public String getRequestAttribute() {
        return reqAttribute;
    }

    @Override
    public String getHomePageName(){
        return resourcePage.getName();
    }
    @Override
    public String getLastModifiedBy(){
        return modifiedBy;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getUrl() {
        return mySimpleService.fetchURL();
    }
}
