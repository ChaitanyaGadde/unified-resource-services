package com.unified.resource.config;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

import com.google.common.base.Predicates;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket serviceProviderApi(Environment env) {
    Contact contact = new Contact("Divya Chaitanya Gadde", "", "divyachaitanyagadde@gmail.com");
    String springActiveProfile = " (" + String.join(",", env.getActiveProfiles()) + ")";
    ApiInfo apiInfo = new ApiInfo("unified-resource-services", "",
        "1.0", "", contact, "", "", new ArrayList<>());

    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select()
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.cloud")))
        .apis(Predicates
            .not(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc")))
        .paths(PathSelectors.any()).build().apiInfo(apiInfo).genericModelSubstitutes(Optional.class)
        .directModelSubstitute(Timestamp.class, String.class);
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("POST", "GET", "PUT", "PATCH", "OPTIONS");
      }
    };
  }

}
