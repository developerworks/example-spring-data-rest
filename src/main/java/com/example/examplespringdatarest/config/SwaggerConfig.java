/**
 * http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
 */
package com.example.examplespringdatarest.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(
//                        RequestHandlerSelectors.basePackage("org.baeldung.web.controller")
//                )
//                .apis(RequestHandlerSelectors.any())
//
//                .paths(PathSelectors.ant("/foos/*"))
//                .build()
//                .apiInfo(apiInfo())
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(
//                        RequestMethod.GET,
//                        Lists.newArrayList(
//                                new ResponseMessageBuilder()
//                                        .code(500)
//                                        .message("500 message")
//                                        .responseModel(
//                                                new ModelRef("Error")
//                                        )
//                                        .build(),
//                                new ResponseMessageBuilder()
//                                        .code(403)
//                                        .message("Forbidden!!!!!")
//                                        .build()
//                        )
//                );
//    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET, new ArrayList<ResponseMessage>())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("龙猫游戏配置中心服务")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .version("1.0")
                .build();
    }
}
