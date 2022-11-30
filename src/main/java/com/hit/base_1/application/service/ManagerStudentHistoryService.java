package com.hit.base_1.application.service;

import com.hit.base_1.domain.dto.ManagerStudentHistoryDto;
import com.hit.base_1.domain.entity.ManagerStudentHistory;

public interface ManagerStudentHistoryService {

  ManagerStudentHistory save(ManagerStudentHistoryDto dto);

}
