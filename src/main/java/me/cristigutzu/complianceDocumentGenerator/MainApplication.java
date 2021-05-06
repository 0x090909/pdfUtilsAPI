package me.cristigutzu.complianceDocumentGenerator;

import io.swagger.jaxrs.config.BeanConfig;
import me.cristigutzu.complianceDocumentGenerator.models.DocumentGeneratorInput;
import me.cristigutzu.complianceDocumentGenerator.models.DocumentMergerInput;
import me.cristigutzu.complianceDocumentGenerator.models.DocumentMergerOutput;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//http://localhost:8080/complianceDocumentGenerator-1.0/api/generate
@ApplicationPath("/api")
public class MainApplication extends Application {
    public MainApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/complianceDocumentGenerator-1.0/api/");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(DocumentGeneratorAPIEndpoint.class);
        resources.add(MainApplication.class);
        resources.add(MainServlet.class);
        resources.add(DocumentGeneratorInput.class);
        resources.add(DocumentMergerInput.class);
        resources.add(DocumentMergerOutput.class);

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}