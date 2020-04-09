package com.unified.resource.datasource;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepository extends CrudRepository<CustomerModel, String> {
  List<CustomerModel> findByStatus(String customerId);
}
