package com.ttn.demo.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Author {
    String getFirstName();
    String getLastName();
    boolean getIsProfessor();
    String getPageTitle();

    @JsonIgnore
    String getRequestAttribute();

    String getHomePageName();

    String getLastModifiedBy();

    String getMessage();

    String getUrl();
}
