package com.unified.resource.datasource;

import com.unified.resource.datasource.dto.CustomerDTO;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
class CustomerModel {
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
  @UpdateTimestamp
  @Column(name = "LAST_UPDATED_TIME")
  private LocalDateTime lastUpdateTime;

  @CreationTimestamp
  @Column(name = "START_TIME", updatable = false, nullable = false)
  private LocalDateTime startTime;

  static CustomerModel fromDto(CustomerDTO dto) {
    CustomerModel testRunModel = CustomerModel.builder().build();
    return testRunModel;
  }

  CustomerDTO getDto() {
    return CustomerDTO.builder()
        .customerId("")
        .build();
  }

}
