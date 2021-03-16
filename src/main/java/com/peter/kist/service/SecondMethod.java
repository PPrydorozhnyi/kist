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
    final var maxValues = findMaxV(inputValues, amountOfStage);
    final var minValues = findMinV(inputValues, amountOfStage);
    final var gurvicSums = gurvicMethod(maxValues, minValues);

    final var posRank = ranking(maxValues);
    final var negRank = ranking(minValues);
    final var gurRank = ranking(gurvicSums);

    final var outputPos = maxValueAdd(maxValues);
    final var outputNeg = maxValueAdd(minValues);
    final var outputGur = maxValueAdd(gurvicSums);

    return new GurvicResult(maxValues, minValues, gurvicSums, posRank, negRank, gurRank);
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

  private List<Double> findMaxV(List<Double> inputValues, Integer amountOfStage){
    List<Double> result = new ArrayList<>();
    double maxValue;
    double currentValue;

    for(int i = 0; i < amountOfStage; ++i){
      maxValue = inputValues.get(i);
      for(int j = i; j < inputValues.size(); j += amountOfStage){
        currentValue = inputValues.get(j);
        if(currentValue > maxValue){
          maxValue = currentValue;
        }
      }
      result.add(maxValue);
    }
    return result;
  }

  private List<Double> findMinV(List<Double> inputValues, Integer amountOfStage){
    List<Double> result = new ArrayList<>();
    double minValue;
    double currentValue;

    for(int i = 0; i < amountOfStage; ++i){
      minValue = inputValues.get(i);
      for(int j = i; j < inputValues.size(); j += amountOfStage){
        currentValue = inputValues.get(j);
        if(currentValue < minValue){
          minValue = currentValue;
        }
      }
      result.add(minValue);
    }
    return result;
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

  private List<Integer> ranking(List<Double> inputList){
    List<Double> sorted = new ArrayList<>(inputList);
    List<Integer> rank = new ArrayList<>();

    for(int i = 0; i < inputList.size(); ++i){
      rank.add(0);
    }

    sorted.sort(Comparator.reverseOrder());
    int index;

    for(int i = 0; i < sorted.size(); ++i){
      index = inputList.indexOf(sorted.get(i));
      rank.set(index, i + 1);
    }

    return rank;
  }
}
