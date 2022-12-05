package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.dai.DateRepository;
import com.hit.base_1.application.service.DateService;
import com.hit.base_1.domain.dto.DateDto;
import com.hit.base_1.domain.entity.Date;
import org.springframework.stereotype.Service;

@Service
public class DateServiceImp implements DateService {
  private final DateRepository dateRepository;

  public DateServiceImp(DateRepository dateRepository) {
    this.dateRepository = dateRepository;
  }

  @Override
  public Date createNewDate(DateDto dto) {
    return dateRepository.save(new Date(dto.getName()));
  }
}
