package com.peter.kist.model.dto.second;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GurvicResult {

  private List<Double> outputPos;
  private List<Double> outputNeg;
  private List<Double> outputGur;

  private int[] posRank;
  private int[] negRank;
  private int[] gurRank;
}
