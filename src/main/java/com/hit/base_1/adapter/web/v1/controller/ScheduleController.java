package com.hit.base_1.adapter.web.v1.controller;

import com.hit.base_1.adapter.web.base.RestApiV1;
import com.hit.base_1.adapter.web.base.VsResponseUtil;
import com.hit.base_1.application.constants.UrlConstant;
import com.hit.base_1.application.service.ScheduleService;
import com.hit.base_1.domain.dto.ScheduleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
public class ScheduleController {
  private final ScheduleService scheduleService;

  public ScheduleController(ScheduleService scheduleService) {
    this.scheduleService = scheduleService;
  }

  @PostMapping(UrlConstant.Schedule.SAVE)
  public ResponseEntity<?> createNewSchedule(@RequestBody ScheduleDto scheduleDto) {
    return VsResponseUtil.ok(scheduleService.createSchedule(scheduleDto));
  }

}
