package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.dai.SubjectRepository;
import com.hit.base_1.application.service.SubjectService;
import com.hit.base_1.domain.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {
  private final SubjectRepository subjectRepository;

  public SubjectServiceImp(SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
  }

  @Override
  public List<Subject> getAllSubject() {
    return subjectRepository.findAll();
  }

}
