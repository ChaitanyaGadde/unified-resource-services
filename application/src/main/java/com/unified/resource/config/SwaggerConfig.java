package com.unified.resource.config;

import com.google.common.base.Predicates;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Value("${spring.application.name:unknown}")
  private String springApplicationName;

  @Value("${maven.description:unknown}")
  private String mavenDescription;

  @Value("${maven.version:unknown}")
  private String mavenVersion;

  @Value("${git.commit.id.abbrev:unknown}")
  private String commitIdAbbrev;

  @Value("${spring.profiles.active:default}")
  private String activeProfile;

  @Bean
  public Docket serviceProviderApi() {
    Contact contact = new Contact("", "", "");
    ApiInfo apiInfo = new ApiInfo(springApplicationName, mavenDescription, String.format("%s | v%s (#%s)", activeProfile, mavenVersion, commitIdAbbrev), "",
      contact, "", "", new ArrayList<>());

    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
      .select()
      .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
      .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.cloud")))
      .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc")))
      .paths(PathSelectors.any()).build().apiInfo(apiInfo).genericModelSubstitutes(Optional.class)
      .directModelSubstitute(Timestamp.class, String.class);
  }
}
