package com.hit.base_1.domain.entity;

import com.hit.base_1.application.constants.TableNameConstant;
import com.hit.base_1.domain.dto.ManagerStudentHistoryDto;
import com.hit.base_1.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNameConstant.TABLE_MANAGER)
public class ManagerStudentHistory extends AbstractAuditingEntity {

  private String studentId;

  private Long subjectId;

  private boolean flag;

  public ManagerStudentHistory(ManagerStudentHistoryDto dto) {
    this.studentId = dto.getStudentCode();
    this.subjectId = dto.getSubjectId();
    this.flag = dto.isFlag();
  }
}
