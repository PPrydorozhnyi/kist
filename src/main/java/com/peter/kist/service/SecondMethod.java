package com.peter.kist.service;

import com.peter.kist.model.dto.second.GurvicResult;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class SecondMethod extends AbstractMethod {

  private static final Double POSITIVE_OUTCOME = 0.6;

  private static final BiPredicate<Double, Double> greater = (x, y) -> x > y;
  private static final BiPredicate<Double, Double> less = (x, y) -> x < y;


  public GurvicResult calculateAll(List<Double> inputValues, Integer amountOfStage) {
    final var maxValues = findSomething(inputValues, amountOfStage, greater);
    final var minValues = findSomething(inputValues, amountOfStage, less);
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
      gurvicSums.add(currentSum);
    }
    return gurvicSums;
  }

  private List<Double> findSomething(List<Double> inputValues, Integer amountOfStage,
                                     BiPredicate<Double, Double> something) {
    List<Double> result = new ArrayList<>();
    double maxValue;
    double currentValue;

    for(int i = 0; i < amountOfStage; ++i){
      maxValue = inputValues.get(i);
      for(int j = i; j < inputValues.size(); j += amountOfStage){
        currentValue = inputValues.get(j);
        if(something.test(currentValue, maxValue)){
          maxValue = currentValue;
        }
      }
      result.add(maxValue);
    }
    return result;
  }

}
