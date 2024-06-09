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
