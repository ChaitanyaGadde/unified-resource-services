package com.unified.resource.customer;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerSlotSaver {

  @PostMapping("/v1/saveSlot")
  public String getMe(String slot) {
    return "OK";
  }

  @GetMapping("/v1/getAvailableSlots")
  public String getAvailableSlots(@RequestParam String allSlots, @RequestHeader Map<String, String > headers) {
    return "OK";
  }
}
