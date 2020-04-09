package com.unified.resource.retail.registration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegisterRetailer {
  @PostMapping("/v1/saveRetailerRegistration")
  public String getMe(
      @RequestHeader(name = "X-Environment", required = true) String environment,
      @RequestHeader(name = "X-Transaction-Id", required = true) String xTransactionId) {
    return "OK";
  }

  @PutMapping("/v1/updateRetailerRegistration")
  public String patchMe(
      @RequestHeader(name = "X-Environment", required = true) String environment,
      @RequestHeader(name = "X-Transaction-Id", required = true) String xTransactionId) {
    return "OK";
  }

  @GetMapping("/v1/retailerNearMe")
  public String getRetailer(
      @RequestHeader(name = "X-Environment", required = true) String environment,
      @RequestHeader(name = "X-Transaction-Id", required = true) String xTransactionId) {
    return "OK";
  }
}
