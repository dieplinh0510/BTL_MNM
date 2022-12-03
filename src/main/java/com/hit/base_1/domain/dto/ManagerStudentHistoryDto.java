package com.hit.base_1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerStudentHistoryDto {

  private String studentCode;

  private String subjectId;

  private boolean flag; // True - vao / False - ra

}
