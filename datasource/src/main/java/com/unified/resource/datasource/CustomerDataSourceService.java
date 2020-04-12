package com.unified.resource.datasource;

import com.unified.resource.datasource.dto.CustomerDTO;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerDataSourceService {

  @Autowired
  private CustomerRepository customerRepository;



  public Optional<CustomerModel> createCustomer(CustomerDTO customerDTO) {
    return Optional.of(customerRepository.save(CustomerModel.fromDTO(customerDTO)));
  }

}
