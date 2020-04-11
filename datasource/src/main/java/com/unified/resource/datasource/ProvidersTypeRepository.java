package com.unified.resource.datasource;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProvidersTypeRepository extends CrudRepository<ProvidersTypeModel, String> {
  List<ProvidersTypeModel> findByIdAndIdentificationId(String phone, String identity);
}
