package com.example.examplespringdatarest.config;

import com.example.examplespringdatarest.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;

@Configuration
@ConditionalOnProperty(value = "app.settings.exposeid", havingValue = "true")
class RestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.exposeIdsFor(User.class);
        config.setBasePath("/");
        config.setDefaultMediaType(MediaType.APPLICATION_JSON_UTF8);
    }
}
