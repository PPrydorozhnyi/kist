package com.peter.kist.model.dto.first;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlternativeResultDto {

  private List<Double> marks;
  private int[] ranks;

}
