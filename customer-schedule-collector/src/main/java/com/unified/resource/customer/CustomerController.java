package com.unified.resource.customer;

import com.unified.resource.common.validators.ServiceException;
import com.unified.resource.common.validators.ValidationHelpers;
import com.unified.resource.controller.RequiredHeaderParams;
import com.unified.resource.datasource.CustomerDataSourceService;
import com.unified.resource.datasource.CustomerModel;
import com.unified.resource.datasource.dto.CustomerDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {

  @Autowired
  private CustomerDataSourceService customerDataSourceService;
  @Autowired
  private ValidationHelpers validateHelpers;

  @RequiredHeaderParams
  @PostMapping(value = "/v1/customer")
  @ApiResponses({@ApiResponse(response = CustomerDTO.class, message = "OK", code = 201),
      @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(
      code = 500, message = "Internal service error occurred")})
  @ApiOperation(value = "Create Customer")
  public String createCustomer(@RequestBody CustomerDTO customerDTO, @RequestHeader HttpHeaders headers) {

    if(validateHelpers.validateHeaders(headers)){
      Optional<CustomerModel> customerCreated = customerDataSourceService.createCustomer(customerDTO) ;
      return customerCreated.get().getCustomerId();
    }else{
      throw new ServiceException("FAILED VALIDATION OF HEADERS");
    }

  }

}
