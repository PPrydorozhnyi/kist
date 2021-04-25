package com.peter.kist.service;

import com.google.common.collect.Lists;
import com.peter.kist.model.dto.third.LaplaceResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThirdMethod extends AbstractMethod {

    public LaplaceResult calculateAll(List<Double> inputValues, Integer amountOfAlternative, Integer amountOfCondition) {
        final var maxCondition = findMaxByCondition(inputValues, amountOfAlternative, amountOfCondition);
        final var sorryMatrix = createSorryMatrix(inputValues, maxCondition, amountOfAlternative, amountOfCondition);

        final var savageResult = findMaxValues(sorryMatrix, amountOfCondition);
        final var laplaceResult = avgSum(inputValues, amountOfCondition);

        final var savageRank = ranking(savageResult);
        final var laplaceRank = ranking(laplaceResult);

        return new LaplaceResult(savageResult, laplaceResult, savageRank, laplaceRank);
    }

    private List<Double> findMaxByCondition(List<Double> inputValues, Integer amountOfAlternative, Integer amountOfCondition) {
        List<Double> maxCondition = new ArrayList<>();

        for (int i = 0; i < amountOfCondition; ++i) {
            for (int j = i; j < amountOfCondition * amountOfAlternative; j += amountOfCondition) {
                maxCondition.add(inputValues.get(j));
            }
        }

        maxCondition = findMaxValues(maxCondition, amountOfAlternative);

        return maxCondition;
    }

    private List<Double> createSorryMatrix(List<Double> inputValues, List<Double> maxConditions, Integer amountOfAlternative, Integer amountOfCondition) {
        List<Double> sorryMatrix = new ArrayList<>();

        for (int i = 0, k = 0; i < amountOfAlternative * amountOfCondition; i += amountOfCondition){
            for(int j = i; k < amountOfCondition; ++j, ++k){
                sorryMatrix.add(maxConditions.get(k) - inputValues.get(j));
            }
            k = 0;
        }
        return sorryMatrix;
    }

    private List<Double> avgSum(List<Double> inputValues, Integer amountOfCondition) {
        return Lists.partition(inputValues, amountOfCondition).stream()
                .map(list -> list.stream()
                        .reduce(0.0, Double::sum) / amountOfCondition)
                .collect(Collectors.toList());
    }
}
