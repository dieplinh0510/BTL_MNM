package com.hit.base_1.application.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTimeTableItemDetailOutput {

  private Integer week;

  private String from;

  private String timeDetail;

}
