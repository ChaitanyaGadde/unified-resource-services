package com.unified.resource.common.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidationHelpers {

  public boolean validateHeaders(HttpHeaders headers) {

    return headers.get("X-Client").equals("chaitu");
  }
}
