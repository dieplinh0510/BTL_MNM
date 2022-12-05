package com.hit.base_1.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

  private String fullName;

  private String major;

  private String studentCode;

  private String studentOfClass;

  private String dateOfBirth;

}
