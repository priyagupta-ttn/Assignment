package com.ttn.demo.core.service.impl;

import com.ttn.demo.core.service.ClassConfigurationService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import java.util.List;

@Component( service = ClassConfigurationServiceImpl.class, immediate = true)
@Designate(ocd = ClassConfigurationServiceImpl.ClassConfiguration.class)
public class ClassConfigurationServiceImpl implements ClassConfigurationService {

    private int maxStudentInClass;
    private int passingMarks;

    @ObjectClassDefinition(name = "Class Configurations for Maximum students and passing marks",
            description = "Class configuration")
    public @interface ClassConfiguration {

        @AttributeDefinition(name = "Maximum Students", required = true,

                description = "Enter No. of students allowed in the class",
                type = AttributeType.INTEGER)
       public int passingMarks() default 50;
        @AttributeDefinition(name = "Passing Marks", required = true,

                description = "Enter Passing marks to pass the class",
                type = AttributeType.INTEGER)
        public  int maxStudentsInClass() default 50;
    }

    @Activate
    public void activate(ClassConfigurationServiceImpl.ClassConfiguration config) {

        maxStudentInClass = config.maxStudentsInClass();
        passingMarks = config.passingMarks();

    }

    @Deactivate
    public void deactivate(ClassConfigurationServiceImpl.ClassConfiguration config) {

        maxStudentInClass = 0;
        passingMarks = 0;

    }

    @Override
    public boolean isClassLimitReached(List<?> students) {

        return students.size() >= maxStudentInClass;
    }

    @Override
    public int getPassingMarks() {
        return passingMarks;
    }
}
