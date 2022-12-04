package com.hit.base_1.application.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTimeTableItemOutput {

  private Long subjectId;

  private String subjectName;

  private String room;

  private String address;

  private String lesson;

  private String timeDetail;

  private List<GetTimeTableItemDetailOutput> timeTableDetails;

}
