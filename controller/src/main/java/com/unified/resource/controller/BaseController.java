package com.unified.resource.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BaseController {

  @ApiOperation(value = "Retrieve information has about based on id",
      notes = "Return  information")
  @GetMapping("/v1/test")
  public String getMe() {
    return "OK";
  }
}

