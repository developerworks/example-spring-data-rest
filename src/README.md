## 1 概述

为什么需要Swagger这种自动化的文档工具. 在过去的软件开发实践过程中, 
我们服务器端程序员和客户端程序员在关于服务器API接口方面的沟通方式
通常都是通过一个接口描述文档来进行沟通和交流的. 无数的实践发现, 通过文档对每个接口的参数, 
返回值进行描述是非常低效的. 体现在一下几个方面:

- 对修改同步不友好

    服务器端修改了代码, 还需要更新接口文档. 这个服务器端工程师带来了额外的工作.

- 对客户端不友好
    
    客户端工程师需要编码对接口进行测试, 不能直观的对接口进行直接测试, 这给客户端工程是测试接口也带来了额外的工作.

### 1.1 Swagger 为我们带来了什么?

它提供了一个可视化的接口调用工具. 其中描述了接口的基本信息, 包括调用地址, 接口列表, 每个接口的详细参数和返回值, 
以及需要的数据格式(json, xml). 除此之外, 它还提供了即时调用的功能, 你可以直接在UI界面中给接口提供参数, 
并且指向调用, 然后可以立即看到返回值. 这省去了客户端工程师编写代码来测试接口的工作.


## 2. 添加Maven依赖

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.7.0</version>
</dependency>
```

## 3. 集成Swagger2到项目

### 3.1 Java 配置

```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}
```

通过 @EnableSwagger2 标注启用Swagger2.

Docket Bean定义之后, `select()` 方法返回一个 **ApiSelectorBuilder** 实例, 它提供了一个方法来控制通过Swagger暴露哪些端点.


### 3.2 配置

`CustomizedRestMvcConfiguration.java`

```java
package com.example.examplespringdatarest.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
public class CustomizedRestMvcConfiguration extends RepositoryRestMvcConfiguration {

    @Override
    @Bean
    public HateoasPageableHandlerMethodArgumentResolver pageableResolver() {

        HateoasPageableHandlerMethodArgumentResolver resolver = super.pageableResolver();

        return resolver;
    }

    /**
     * 暴露Swagger UI的静态支援地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
```
### 3.3 验证

```
http://localhost:8080/spring-security-rest/api/v2/api-docs
```

## 4 Swagger UI

### 4.1 启用 Springfox Swagger UI 

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.7.0</version>
</dependency>
```

现在就可以通过浏览器访问了: http://localhost:8080/your-app-root/swagger-ui.html


## 自定义方法响应消息

Swagger 允许通过 Docket 的 **globalResponseMessage()** 方法全局覆盖HTTP方法的响应消息. 首先你需要让Swagger不要使用默认的响应消息.

假设你要针对所有的GET 方法覆盖500和403响应消息. 为此, 必须添加一些配置代码到Docket的初始话代码块, 例如:

```java
.useDefaultResponseMessages(false)                                   
.globalResponseMessage(RequestMethod.GET,                     
  newArrayList(new ResponseMessageBuilder()   
    .code(500)
    .message("500 message")
    .responseModel(new ModelRef("Error"))
    .build(),
    new ResponseMessageBuilder() 
      .code(403)
      .message("Forbidden!")
      .build()));
``` 
