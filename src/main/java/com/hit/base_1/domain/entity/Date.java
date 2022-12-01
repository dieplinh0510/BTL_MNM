package com.hit.base_1.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hit.base_1.application.constants.TableNameConstant;
import com.hit.base_1.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNameConstant.TABLE_DATE)
public class Date extends AbstractAuditingEntity {

  private String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subject")
  @JsonIgnore
  private List<Schedule> schedules;

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  private ScheduleDetail scheduleDetail;

}
