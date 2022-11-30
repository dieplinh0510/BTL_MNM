package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.dai.ManagerStudentHistoryRepository;
import com.hit.base_1.application.service.ManagerStudentHistoryService;
import com.hit.base_1.domain.dto.ManagerStudentHistoryDto;
import com.hit.base_1.domain.entity.ManagerStudentHistory;
import org.springframework.stereotype.Service;

@Service
public class ManagerStudentHistoryServiceImp implements ManagerStudentHistoryService {
  private final ManagerStudentHistoryRepository managerStudentHistoryRepository;

  public ManagerStudentHistoryServiceImp(ManagerStudentHistoryRepository managerStudentHistoryRepository) {
    this.managerStudentHistoryRepository = managerStudentHistoryRepository;
  }

  @Override
  public ManagerStudentHistory save(ManagerStudentHistoryDto dto) {
    return managerStudentHistoryRepository.save(new ManagerStudentHistory(dto));
  }

}
