package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestApiV1
public class SubjectController {
  private final SubjectService subjectService;

  public SubjectController(SubjectService subjectService) {
    this.subjectService = subjectService;
  }

  // API lấy tất cả subject
  @GetMapping(UrlConstant.Subject.LIST)
  public ResponseEntity<?> getAllSubject() {
    return VsResponseUtil.ok(subjectService.getAllSubject());
  }


  // API get data màn time table
  @GetMapping(UrlConstant.Subject.TIME_TABLE)
  public ResponseEntity<?> getTimeTable() {
    return VsResponseUtil.ok(subjectService.getTimeTable());
  }


  // API lấy tất cả lớp học bởi user login
  @GetMapping(UrlConstant.Subject.LIST_STUDENT)
  public ResponseEntity<?> getAllSubjectByUserLogin() {
    return VsResponseUtil.ok(subjectService.getAllSubjectByUserLogin());
  }


  // API lấy hết user của 1 lớp học
  @GetMapping(UrlConstant.Subject.LIST_STUDENT_IN_SUBJECT)
  public ResponseEntity<?> getAllUserBySubjectId(@PathVariable("subjectId") Long subjectId) {
    return VsResponseUtil.ok(subjectService.getAllStudentBySubjectId(subjectId));
  }

}
