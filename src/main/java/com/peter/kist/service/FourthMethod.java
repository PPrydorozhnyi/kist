package com.peter.kist.service;


import com.google.common.collect.Lists;
import com.peter.kist.model.dto.fourth.ParetoResultDto;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class FourthMethod {

    public ParetoResultDto calculateAll(List<String> inputValues, int amountOfAlternatives) {
        var listInput = parsingList(inputValues, amountOfAlternatives);
        var pairPareto = createParetoAndMap(listInput);
        rankingMap(pairPareto.getRight(), listInput);
        paretoComparing(pairPareto.getRight(), pairPareto.getLeft());

        return new ParetoResultDto(pairPareto.getRight(), pairPareto.getLeft());
    }

    private List<List<String>> parsingList(List<String> inputValues, Integer amountOfAlternatives){
        return Lists.partition(inputValues, 2 * amountOfAlternatives - 1);
    }

    private void paretoComparing(Map<String, List<Integer>> rankedMap, Set<String> pareto) {

        for (String keys : rankedMap.keySet()) {
            for (String keys2 : rankedMap.keySet()) {

                if (keys.equals(keys2))
                    continue;

                var result = new HashSet<Integer>();
                var firstList = rankedMap.get(keys);
                var secondList = rankedMap.get(keys2);

                for (int i = 0; i < firstList.size(); ++i) {
                    result.add(Integer.compare(firstList.get(i), secondList.get(i)));
                }

                if (result.size() <= 2 && !result.containsAll(Set.of(1, -1))) {
                    var sum = result.stream()
                            .reduce(0, Integer::sum);
                    if (sum > 0) {
                        pareto.remove(keys);
                    } else if (sum < 0) {
                        pareto.remove(keys2);
                    }
                }
            }
        }
    }

    private void rankingMap(Map<String, List<Integer>> rankedMap, List<List<String>> inputValues) {
        int counter;

        for (List<String> input : inputValues) {
            counter = 1;
            for (int i = 0; i < input.size(); ++i) {
                if (i % 2 == 0) {
                    rankedMap.get(input.get(i)).add(counter);
                } else {
                    counter += Integer.parseInt(input.get(i));
                }
            }
        }
    }

    private Pair<Set<String>, Map<String, List<Integer>>> createParetoAndMap(List<List<String>> inputValues) {
        var rankedMap = new HashMap<String, List<Integer>>();
        var pareto = new HashSet<String>();

        var values = inputValues.get(0);

        for (int i = 0; i < values.size(); ++i) {
            if (i % 2 == 0) {
                var currentOne = values.get(i);

                rankedMap.put(currentOne, new ArrayList<>());
                pareto.add(currentOne);
            }
        }
        return Pair.of(pareto, rankedMap);
    }


}
