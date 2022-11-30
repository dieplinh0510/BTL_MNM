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
@Table(name = TableNameConstant.TABLE_STUDENT_SUBJECT)
public class StudentSubject extends AbstractAuditingEntity {

    private Integer numberOfStudy;

    private boolean status;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Student student;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Subject subject;

}
