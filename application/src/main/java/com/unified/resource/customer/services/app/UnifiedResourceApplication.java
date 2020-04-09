package com.unified.resource.customer.services.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.unified.resource.*"}, exclude = {RabbitAutoConfiguration.class})
public class UnifiedResourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UnifiedResourceApplication.class, args);
  }
}
