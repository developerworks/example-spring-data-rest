package com.example.examplespringdatarest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CustomizedRestMvcConfiguration extends WebMvcConfigurerAdapter {

//    @Override
//    @Bean
//    public HateoasPageableHandlerMethodArgumentResolver pageableResolver() {
//
//        HateoasPageableHandlerMethodArgumentResolver resolver = super.pageableResolver();
////        resolver.setOneIndexedParameters(true);
//
//        return resolver;
//    }

    /**
     * 暴露Swagger UI的静态支援地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        super.configureContentNegotiation(configurer);
//        configurer.favorPathExtension(false).
//                favorParameter(true).
//                parameterName("mediaType").
//                ignoreAcceptHeader(true).
//                useJaf(false).
//                defaultContentType(MediaType.APPLICATION_JSON).
//                mediaType("xml", MediaType.APPLICATION_XML).
//                mediaType("json", MediaType.APPLICATION_JSON);
//    }
}
