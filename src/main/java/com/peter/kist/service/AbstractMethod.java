package com.peter.kist.service;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractMethod {

  protected int[] rankingSavage(List<Double> inputList){
    int[] rank = new int[inputList.size()];
    int counter = 1;

    TreeSet<Double> sortedSet = new TreeSet<>(Comparator.naturalOrder());
    sortedSet.addAll(inputList);

    for(Double value : sortedSet) {
      final var allIndexes = findAllIndexes(inputList, value);
      for (int ind : allIndexes) {
        if (rank[ind] == 0) {
          rank[ind] = counter;
        }
      }
      ++counter;
    }

    return rank;
  }

  protected int[] ranking(List<Double> inputList){
    int[] rank = new int[inputList.size()];
    int counter = 1;

    TreeSet<Double> sortedSet = new TreeSet<>(Comparator.reverseOrder());
    sortedSet.addAll(inputList);

    for(Double value : sortedSet) {
      final var allIndexes = findAllIndexes(inputList, value);
      for (int ind : allIndexes) {
        if (rank[ind] == 0) {
          rank[ind] = counter;
        }
      }
      ++counter;
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
