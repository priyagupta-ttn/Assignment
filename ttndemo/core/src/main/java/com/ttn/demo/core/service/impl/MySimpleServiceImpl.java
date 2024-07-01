package com.ttn.demo.core.service.impl;


import com.ttn.demo.core.service.MySimpleService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component( service = MySimpleService.class, immediate = true,name = "serviceDemoImpl")
@Designate(ocd = MySimpleServiceImpl.MyServiceConfiguration.class)
public class MySimpleServiceImpl implements MySimpleService {

    private String hostUrl;


    @ObjectClassDefinition(name = "My Simple service Configuration")

    public @interface MyServiceConfiguration {

        @AttributeDefinition(name = "API Host Url", required = true,

                description = "Url at which api is hosted. Url must start with either http or https")

        String api_host_url() default "www.gmb.com";

    }

    @Activate
    public void activate(MyServiceConfiguration config) {

        hostUrl = config.api_host_url();

    }

    @Modified
    public void modified(MyServiceConfiguration config) {

        hostUrl = config.api_host_url();

    }

    @Deactivate
    public void deactivate(MyServiceConfiguration config) {

        hostUrl = "";

    }
    @Override
    public String fetchURL() {
        return null;
    }
}
