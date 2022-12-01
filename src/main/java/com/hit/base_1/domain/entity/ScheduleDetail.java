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
@Table(name = TableNameConstant.TABLE_SCHEDULE_DETAIL)
public class ScheduleDetail extends AbstractAuditingEntity {

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  private Schedule schedule;

  private String lesson; // tiết học

  private String form; // Hình thức

  private String timeDetail;

  private Integer week;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "scheduleDetail")
  @JsonIgnore
  private List<Date> dates;

}
