package com.peter.kist.model.dto.second;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GurvicResult {

  private List<Double> outputPos;
  private List<Double> outputNeg;
  private List<Double> outputGur;

}
