package com.hit.base_1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

  private Long subjectId;

  private Long dateId;

  private String room;

  private String address;

  private List<ScheduleDetailDto> scheduleDetailDtos;

}
