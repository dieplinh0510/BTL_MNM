package com.hit.base_1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDetailDto {

  private String form;

  private String lesson;

  private String timeDetail;

  private Integer week;

}
