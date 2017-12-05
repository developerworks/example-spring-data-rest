package com.example.examplespringdatarest.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "app.settings")
@PropertySource("classpath:application.properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationConfigurationProperties {
    private Boolean exposeId;
}
