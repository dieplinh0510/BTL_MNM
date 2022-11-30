package com.hit.base_1.domain.entity;

import com.hit.base_1.application.constants.TableNameConstant;
import com.hit.base_1.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNameConstant.TABLE_SCHEDULE)
public class Schedule extends AbstractAuditingEntity {

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  private Subject subject;

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  private Date date;

}
