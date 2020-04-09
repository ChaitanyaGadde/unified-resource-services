package com.unified.resource.retail.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RetailNotifier {

  @PostMapping("/v1/notifyRetailerOnOrder")
  public String getMe(
      @RequestHeader(name = "X-Environment", required = true) String environment,
      @RequestHeader(name = "X-Transaction-Id", required = true) String xTransactionId) {
    return "OK";
  }
}
