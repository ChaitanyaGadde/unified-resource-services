package com.unified.resource.config;

import lombok.Data;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class Slf4jMDCFilterConfiguration {

  @Value("${spring.application.name}")
  private String springApplicationName;

  @Value("${maven.groupId}")
  private String mavenGroupId;

  @Value("${maven.artifactId}")
  private String mavenArtifactId;

  @Value("${maven.version}")
  private String mavenVersion;

  @Value("${git.commit.id.abbrev}")
  private String commitIdAbbrev;

  @Bean
  public void registerCotnext() {
    MDC.put("applicationName", springApplicationName);
    MDC.put("mavenGroupId", mavenGroupId);
    MDC.put("mavenArtifactId", mavenArtifactId);
    MDC.put("mavenVersion", mavenVersion);
    MDC.put("commitIdAbbrev", commitIdAbbrev);
  }

  @Bean
  public FilterRegistrationBean servletRegistrationBean() {
    final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    Slf4jMDCFilter log4jMDCFilterFilter = new Slf4jMDCFilter();
    registrationBean.setFilter(log4jMDCFilterFilter);
    registrationBean.setOrder(2);
    return registrationBean;
  }
}
