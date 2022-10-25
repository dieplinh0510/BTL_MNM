package com.hit.base_1.domain.entity.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractAuditingEntity implements Serializable {

  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("createdBy")
  private Long createdBy;

  @CreationTimestamp
  private Timestamp createdDate;

  @JsonProperty("lastModifiedBy")
  private Long lastModifiedBy;

  @UpdateTimestamp
  private Timestamp lastModifiedDate;

}
