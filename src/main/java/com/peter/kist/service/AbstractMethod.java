package com.peter.kist.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractMethod {

  protected List<Integer> ranking(List<Double> inputList){
    List<Double> sorted = new ArrayList<>(inputList);
    List<Integer> rank = new ArrayList<>();

    for(int i = 0; i < inputList.size(); ++i){
      rank.add(0);
    }

    sorted.sort(Comparator.reverseOrder());

    for(int i = 0; i < sorted.size(); ++i) {
      final var allIndexes = findAllIndexes(inputList, sorted.get(i));
      for (int ind : allIndexes) {
        if (rank.get(ind) == 0) {
          rank.set(ind, i + 1);
        }
      }
    }

    return rank;
  }

  private List<Integer> findAllIndexes(List<Double> list, Double value) {
    return IntStream.range(0, list.size())
        .filter(i -> value.equals(list.get(i)))
        .boxed()
        .collect(Collectors.toList());
  }

}
