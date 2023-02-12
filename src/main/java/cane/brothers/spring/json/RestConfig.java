package cane.brothers.spring.json;

import cane.brothers.spring.json.source.Source;
import cane.brothers.spring.json.source_attributes.SourceAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    // expose entity ID's
    config.exposeIdsFor(Source.class, SourceAttributes.class);

    // hide PUT/PATCH endpoints
    ExposureConfiguration exposureConfiguration = config.getExposureConfiguration();
    exposureConfiguration
        .withItemExposure((metadata, httpMethods) ->
            httpMethods.disable(HttpMethod.PUT).disable(HttpMethod.PATCH))
        .withCollectionExposure((metadata, httpMethods) ->
            httpMethods.disable(HttpMethod.PUT).disable(HttpMethod.PATCH));
  }

}
