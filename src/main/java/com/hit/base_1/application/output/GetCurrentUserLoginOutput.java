package com.hit.base_1.application.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCurrentUserLoginOutput {

  private String studentCode;

  private String fullName;

  private String avatar;

  private String studentOfClass;

  private String major;

  private String dateOfBirth;

}
