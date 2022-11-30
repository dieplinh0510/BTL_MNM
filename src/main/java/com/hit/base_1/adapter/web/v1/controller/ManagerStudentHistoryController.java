package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.service.ManagerStudentHistoryService;
import com.hit.base_1.domain.dto.ManagerStudentHistoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
public class ManagerStudentHistoryController {
  private final ManagerStudentHistoryService managerStudentHistoryService;

  public ManagerStudentHistoryController(ManagerStudentHistoryService managerStudentHistoryService) {
    this.managerStudentHistoryService = managerStudentHistoryService;
  }

  @PostMapping(UrlConstant.Log.SAVE)
  public ResponseEntity<?> saveLog(@RequestBody ManagerStudentHistoryDto dto) {
    return VsResponseUtil.ok(managerStudentHistoryService.save(dto));
  }

}
