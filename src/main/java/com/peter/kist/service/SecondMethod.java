package com.peter.kist.service;

import com.peter.kist.model.dto.second.GurvicResult;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SecondMethod extends AbstractMethod {

  private static final Double POSITIVE_OUTCOME = 0.6;


  public GurvicResult calculateAll(List<Double> inputValues, Integer amountOfStage) {
    final var maxValues = findMaxValues(inputValues, amountOfStage);
    final var minValues = findMinValues(inputValues, amountOfStage);
    final var gurvicSums = gurvicMethod(maxValues, minValues);

    final var posRank = ranking(maxValues);
    final var negRank = ranking(minValues);
    final var gurRank = ranking(gurvicSums);

    return new GurvicResult(maxValues, minValues, gurvicSums, posRank, negRank, gurRank);
  }

  private List<Double> gurvicMethod(List<Double> maxValues, List<Double> minValues) {
    List<Double> gurvicSums = new ArrayList<>();
    double currentSum;
    for (int i = 0; i < maxValues.size(); ++i) {
      currentSum = maxValues.get(i) * POSITIVE_OUTCOME + (1 - POSITIVE_OUTCOME) * minValues.get(i);
      BigDecimal bd = BigDecimal.valueOf(currentSum).setScale(4, RoundingMode.HALF_UP);
      gurvicSums.add(bd.doubleValue());
    }
    return gurvicSums;
  }

}
