package com.unified.resource.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerNotifier {

  @Scheduled(fixedRate = 100000)
  public String checkAnyUpdatesCustomerInterested() {

    return "OK";
  }
}
