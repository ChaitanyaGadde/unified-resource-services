package com.unified.resource.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerTrackOrders {

  @GetMapping("/v1/getCurrentOrder")
  public String getMe(
      @RequestHeader(name = "X-Environment", required = true) String environment,
      @RequestHeader(name = "X-Transaction-Id", required = true) String xTransactionId) {
    return "OK";  }

  @GetMapping("/v1/getAllOrders")
  public String getAllOrders(
      @RequestHeader(name = "X-Environment", required = true) String environment,
      @RequestHeader(name = "X-Transaction-Id", required = true) String xTransactionId) {
    return "OK";
  }
}
