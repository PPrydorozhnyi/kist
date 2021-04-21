package com.peter.kist.service;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractMethod {

  protected int[] ranking(List<Double> inputList){
    List<Double> sorted = new ArrayList<>(inputList);
    int[] rank = new int[inputList.size()];

    sorted.sort(Comparator.reverseOrder());

    for(int i = 0; i < sorted.size(); ++i) {
      final var allIndexes = findAllIndexes(inputList, sorted.get(i));
      for (int ind : allIndexes) {
        if (rank[ind] == 0) {
          rank[ind] = i + 1;
        }
      }
    }

    return rank;
  }

  protected List<Double> findMaxValues(List<Double> inputValues, Integer amountOfStage) {
    return Lists.partition(inputValues, amountOfStage).parallelStream()
            .map(list -> list.stream()
                    .max(Comparator.comparingDouble(Double::doubleValue))
                    .orElse(Double.MIN_VALUE))
            .collect(Collectors.toList());
  }


  protected List<Double> findMinValues(List<Double> inputValues, Integer amountOfStage) {
    return Lists.partition(inputValues, amountOfStage).parallelStream()
            .map(list -> list.stream()
                    .min(Comparator.comparingDouble(Double::doubleValue))
                    .orElse(Double.MAX_VALUE))
            .collect(Collectors.toList());
  }

  private List<Integer> findAllIndexes(List<Double> list, Double value) {
    return IntStream.range(0, list.size())
        .filter(i -> value.equals(list.get(i)))
        .boxed()
        .collect(Collectors.toList());
  }

}
