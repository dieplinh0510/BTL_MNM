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
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = TableNameConstant.TABLE_STUDENT)
public class Student extends AbstractAuditingEntity {

    private String studentId;

    private String fullName;

    private String avatar;

    private String studentOfClass;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "subject")
    @JsonIgnore
    private List<StudentSubject> studentSubjects;

    private String major;

    private String dateOfBirth;

}
