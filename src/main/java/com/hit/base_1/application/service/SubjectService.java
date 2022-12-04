package com.hit.base_1.application.service;

import com.hit.base_1.application.output.GetDetailStudentInfoOutput;
import com.hit.base_1.application.output.GetTimeTableItemDetailOutput;
import com.hit.base_1.application.output.GetTimeTableItemOutput;
import com.hit.base_1.application.output.GetTimeTableOutput;
import com.hit.base_1.domain.entity.Student;
import com.hit.base_1.domain.entity.Subject;

import java.util.List;

public interface SubjectService {

  List<Subject> getAllSubject();

  GetTimeTableOutput getTimeTable();

  List<Subject> getAllSubjectByUserLogin();

  List<Student> getAllStudentBySubjectId(Long subjectId);

  GetTimeTableItemOutput getTimeTableDetail(Long subjectId);

  GetDetailStudentInfoOutput getDetailInfoStudent(Long subjectId, String studentCode);

}
