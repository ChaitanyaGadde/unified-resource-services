package com.unified.resource.datasource.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.unified.resource.app"})
public class UnifiedResourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UnifiedResourceApplication.class, args);
  }
}
