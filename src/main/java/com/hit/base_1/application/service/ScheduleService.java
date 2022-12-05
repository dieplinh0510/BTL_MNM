package com.hit.base_1.application.service;

import com.hit.base_1.domain.dto.ScheduleDto;
import com.hit.base_1.domain.entity.Schedule;

public interface ScheduleService {

  Schedule createSchedule(ScheduleDto scheduleDto);

}
