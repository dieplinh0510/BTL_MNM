package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.service.SubjectService;
import com.hit.base_1.domain.dto.SubjectDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

  // API get data màn time table
  @GetMapping(UrlConstant.Subject.TIME_TABLE_DETAIL)
  public ResponseEntity<?> getTimeTableDetail(@PathVariable("subjectId") Long subjectId) {
    return VsResponseUtil.ok(subjectService.getTimeTableDetail(subjectId));
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

  // API get màn detail của student trong 1 subject
  @GetMapping(UrlConstant.Subject.DETAIL_STUDENT)
  public ResponseEntity<?> getDetailStudentInSubject(@PathVariable("subjectId") Long subjectId,
                                                     @PathVariable("studentCode") String studentCode) {
    return VsResponseUtil.ok(subjectService.getDetailInfoStudent(subjectId,studentCode));
  }

  @PostMapping(UrlConstant.Subject.SAVE)
  public ResponseEntity<?> save(@RequestBody SubjectDto dto) {
    return VsResponseUtil.ok(subjectService.createNewSubject(dto));
  }
}
