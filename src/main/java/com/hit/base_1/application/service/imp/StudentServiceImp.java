package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.dai.StudentRepository;
import com.hit.base_1.application.service.StudentService;
import com.hit.base_1.config.exception.VsException;
import com.hit.base_1.domain.dto.StudentDto;
import com.hit.base_1.domain.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
  private final StudentRepository studentRepository;

  public StudentServiceImp(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student createNewStudent(StudentDto studentDto) {
    if (studentRepository.findByStudentId(studentDto.getStudentCode()) != null) {
      throw new VsException("invalid.general", "Đã tồn tại studentCode");
    }
    return studentRepository.save(new Student(studentDto.getFullName(), studentDto.getMajor(),
        studentDto.getStudentCode(), studentDto.getStudentOfClass(), studentDto.getDateOfBirth()));
  }
}
