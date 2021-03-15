package com.peter.kist.model.dto.second;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GurvicResult {

  private Double outputPos;
  private Double outputNeg;
  private Double outputGur;

}
