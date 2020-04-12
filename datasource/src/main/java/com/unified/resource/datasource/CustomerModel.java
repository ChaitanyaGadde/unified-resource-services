package com.unified.resource.datasource;

import static java.util.UUID.randomUUID;

import com.unified.resource.datasource.dto.CustomerDTO;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "CUSTOMER_DETAILS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {

  @Id
  @Column(name = "CUSTOMER_ID", nullable = false, length = 125)
  private String customerId;
  @Column(name = "FIRST_NAME", nullable = false, length = 200)
  private String firstName;
  @Column(name = "LAST_NAME", nullable = false, length = 200)
  private String lastName;
  @Column(name = "MIDDLE_NAME", nullable = false, length = 200)
  private String middleName;
  @Column(name = "EMAIL_ID", nullable = false, length = 500)
  private String emailId;
  @Column(name = "ADDRESS", nullable = false, length = 500)
  private String address;
  @Column(name = "STREET1", nullable = false, length = 200)
  private String street1;
  @Column(name = "STREET2", nullable = false, length = 200)
  private String street2;
  @Column(name = "PHONE_NUMBER", nullable = false, length = 200)
  private String phoneNumber;
  @Column(name = "PINCODE", nullable = false, length = 50)
  private String pincode;
  @Column(name = "CITY", nullable = false, length = 200)
  private String city;
  @Column(name = "COUNTRY", nullable = false, length = 200)
  private String country;
  @Column(name = "PASSWORD", nullable = false, length = 200)
  private String password;
  @UpdateTimestamp
  @Column(name = "LAST_UPDATED_TIME")
  private LocalDateTime lastUpdateTime;

  @CreationTimestamp
  @Column(name = "START_TIME", updatable = false, nullable = false)
  private LocalDateTime startTime;

  static CustomerModel fromDTO(CustomerDTO customerDTO){
    return CustomerModel.builder().
        address(customerDTO.getAddress())
        .firstName(customerDTO.getFirstName())
        .lastName(customerDTO.getLastName())
        .middleName(customerDTO.getMiddleName())
        .emailId(customerDTO.getEmailId())
        .address(customerDTO.getAddress())
        .street1(customerDTO.getStreet1())
        .street2(customerDTO.getStreet2())
        .phoneNumber(customerDTO.getPhoneNumber())
        .pincode(customerDTO.getPincode())
        .city(customerDTO.getCity())
        .country(customerDTO.getCountry())
        .password(customerDTO.getPassword())
        .customerId(randomUUID().toString())
    .build();
  }
}
