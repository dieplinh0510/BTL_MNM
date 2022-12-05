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
@Table(name = TableNameConstant.TABLE_SCHEDULE)
public class Schedule extends AbstractAuditingEntity {

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  private Subject subject;

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  private Date date;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "schedule")
  @JsonIgnore
  private List<ScheduleDetail> scheduleDetails;

  private String address;

  private String room;

  public Schedule(Subject subject, Date date, String address, String room) {
    this.subject = subject;
    this.date = date;
    this.address = address;
    this.room = room;
  }
}
