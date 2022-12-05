package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.service.StudentService;
import com.hit.base_1.domain.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping(UrlConstant.Student.SAVE)
  public ResponseEntity<?> save(@RequestBody StudentDto dto) {
    return VsResponseUtil.ok(studentService.createNewStudent(dto));
  }

}
