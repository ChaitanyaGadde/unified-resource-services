package com.unified.resource.datasource;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ServiceProviderRepository extends CrudRepository<ServiceProviderModel, String> {
  List<ServiceProviderModel> findByPhoneNumber(String phone);
}
