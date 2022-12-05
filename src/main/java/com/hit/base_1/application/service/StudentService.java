package com.hit.base_1.application.service;

import com.hit.base_1.domain.dto.StudentDto;
import com.hit.base_1.domain.entity.Student;

public interface StudentService {

  Student createNewStudent(StudentDto studentDto);

}
