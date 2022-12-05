package com.hit.base_1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

  private String name;

  private String numberOfUnit;

  private Long startTime;

  private Long endTime;

  private Double percents;

}
