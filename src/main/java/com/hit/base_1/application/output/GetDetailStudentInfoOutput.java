package com.hit.base_1.application.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDetailStudentInfoOutput {

  private String studentName;

  private String studentCode;

  private String subjectName;

  private String grade;

  private Integer numberOfBreaks;

  private boolean condition;

}
