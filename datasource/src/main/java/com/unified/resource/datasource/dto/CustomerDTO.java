package com.unified.resource.datasource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {

  private String customerId;
  private String firstName;
  private String lastName;
  private String middleName;
  private String emailId;
  private String address;
  private String street1;
  private String street2;
  private String phoneNumber;
  private String pincode;
  private String city;
  private String country;
  private String password;

}
