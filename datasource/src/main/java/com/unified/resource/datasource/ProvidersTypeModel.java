package com.unified.resource.datasource;

import com.unified.resource.datasource.dto.providerDTO;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "PROVIDERS_TYPE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ProvidersTypeModel {
  @Id
  @Column(name = "ID", nullable = false, length = 125)
  private String id;

  @Column(name = "PROVIDER_TYPE", nullable = false, length = 200)
  private String providerType;
  @Column(name = "IDENTIFICATION_TYPE", nullable = false, length = 200)
  private String identificationType;
  @Column(name = "IDENTIFICATION_ID", nullable = false, length = 50)
  private String identificationId;

  @UpdateTimestamp
  @Column(name = "LAST_UPDATED_TIME")
  private LocalDateTime lastUpdateTime;

  @CreationTimestamp
  @Column(name = "START_TIME", updatable = false, nullable = false)
  private LocalDateTime startTime;

  @ManyToOne
  @JoinColumn(name = "PROVIDER_TYPE_ID")
  private ServiceProviderModel serviceProviderModel;
  }
