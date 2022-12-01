package com.hit.base_1.application.service;

import com.hit.base_1.application.output.GetTimeTableOutput;
import com.hit.base_1.domain.entity.Subject;

import java.util.List;

public interface SubjectService {

  List<Subject> getAllSubject();

  GetTimeTableOutput getTimeTable();

}
