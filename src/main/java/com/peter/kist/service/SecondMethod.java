package com.peter.kist.service;

import com.google.common.collect.Lists;
import com.peter.kist.model.dto.second.GurvicResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondMethod {

  private static final Double POSITIVE_OUTCOME = 0.6;

  public GurvicResult calculateAll(List<Double> inputValues, Integer amountOfStage) {
    final var maxValues = findMaxValues(inputValues, amountOfStage);
    final var minValues = findMinValues(inputValues, amountOfStage);
    final var gurvicSums = gurvicMethod(maxValues, minValues);

    final var outputPos = maxValueAdd(maxValues);
    final var outputNeg = maxValueAdd(minValues);
    final var outputGur = maxValueAdd(gurvicSums);

    return new GurvicResult(outputPos, outputNeg, outputNeg);
  }

  private List<Double> gurvicMethod(List<Double> maxValues, List<Double> minValues) {
    List<Double> gurvicSums = new ArrayList<>();
    double currentSum;
    for (int i = 0; i < maxValues.size(); ++i) {
      currentSum = maxValues.get(i) * POSITIVE_OUTCOME + (1 - POSITIVE_OUTCOME) * minValues.get(i);
      gurvicSums.add(currentSum);
    }
    return gurvicSums;
  }

  private List<Double> findMaxValues(List<Double> inputValues, Integer amountOfStage) {
    return Lists.partition(inputValues, amountOfStage).parallelStream()
        .map(list -> list.stream()
            .max(Comparator.comparingDouble(Double::doubleValue))
            .orElse(Double.MIN_VALUE))
        .collect(Collectors.toList());
  }

  private List<Double> findMinValues(List<Double> inputValues, Integer amountOfStage) {
    return Lists.partition(inputValues, amountOfStage).parallelStream()
        .map(list -> list.stream()
            .min(Comparator.comparingDouble(Double::doubleValue))
            .orElse(Double.MAX_VALUE))
        .collect(Collectors.toList());
  }

  private Double maxValueAdd(List<Double> valuesList) {
    return valuesList.stream()
        .max(Comparator.comparingDouble(Double::doubleValue))
        .orElse(Double.MIN_VALUE);
  }

}
