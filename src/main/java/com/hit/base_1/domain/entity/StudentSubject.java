package com.hit.base_1.domain.entity;

import com.hit.base_1.application.constants.TableNameConstant;
import com.hit.base_1.domain.entity.base.StudentSubjectKey;
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
public class StudentSubject  {
    @EmbeddedId
    StudentSubjectKey id;

    private int numberOfStudy;
    private boolean status;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    Student student;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subjectId")
    Subject subject;
}
