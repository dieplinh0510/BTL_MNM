package com.hit.base_1.application.service;

import com.hit.base_1.domain.dto.DateDto;
import com.hit.base_1.domain.entity.Date;

public interface DateService {

  Date createNewDate(DateDto dto);

}
