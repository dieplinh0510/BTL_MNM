package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.service.DateService;
import com.hit.base_1.domain.dto.DateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
public class DateController {
  private final DateService dateService;

  public DateController(DateService dateService) {
    this.dateService = dateService;
  }

  @PostMapping(UrlConstant.Date.SAVE)
  public ResponseEntity<?> save(@RequestBody DateDto dto) {
    return VsResponseUtil.ok(dateService.createNewDate(dto));
  }

}
