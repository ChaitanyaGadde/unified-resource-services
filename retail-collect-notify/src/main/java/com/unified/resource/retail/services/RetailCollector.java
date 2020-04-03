package com.unified.resource.retail.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
@Slf4j
public class RetailCollector {

  @GetMapping("/v1/getRetailCollector")
  public String getMe(
      @RequestHeader(name = "X-Environment", required = true) String environment,
      @RequestHeader(name = "X-Transaction-Id", required = true) String xTransactionId) {
    return "OK";
  }
}
