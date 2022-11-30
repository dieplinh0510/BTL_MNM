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
@Table(name = TableNameConstant.TABLE_SUBJECT)
public class Subject extends AbstractAuditingEntity {

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subject")
  @JsonIgnore
  private List<StudentSubject> studentSubjects;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subject")
  @JsonIgnore
  private List<Schedule> schedules;

  private String name;

  private String numberOfUnit;

  private Long startTime;

  private Long endTime;

  private Double percents;

}
