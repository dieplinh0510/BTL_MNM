package com.hit.base_1.domain.entity.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentSubjectKey implements Serializable {
    @Column(name = "studentId")
    private Long studentId;

    @Column(name = "subjectId")
    Long subjectId;

}
