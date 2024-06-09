package com.ttn.demo.core.service;

import java.util.List;

public interface ClassConfigurationService {
    boolean isClassLimitReached(List<?> students);

    int getPassingMarks();
}
