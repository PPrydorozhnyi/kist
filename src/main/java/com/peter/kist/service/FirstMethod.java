package com.peter.kist.service;

import com.google.common.collect.Lists;
import com.peter.kist.model.dto.first.AlternativeResultDto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FirstMethod extends AbstractMethod {

  private final List<Integer> inputValues;
  private final Integer amountOfExpert;
  private final Integer amountOfAlternative;

  private List<Integer> calculateSum() {
    return Lists.partition(inputValues, amountOfAlternative).parallelStream()
        .map(list -> list.stream().reduce(0, Integer::sum))
        .collect(Collectors.toList());
  }

  private List<Double> calculateNormalMark(List<Integer> sumExpertMarks) {
    double currentValue;
    double currentSum = 0;
    List<Double> normalMark = new ArrayList<>();

    for (int i = 0; i < amountOfAlternative; ++i) {
      for (int j = 0; j < amountOfExpert; ++j) {
        currentValue =
            ((double) inputValues.get(amountOfAlternative * j + i) / sumExpertMarks.get(j));
        currentSum += currentValue;
      }
      currentSum /= amountOfExpert;
      BigDecimal bd = BigDecimal.valueOf(currentSum).setScale(4, RoundingMode.HALF_UP);
      normalMark.add(bd.doubleValue());
      currentSum = 0;
    }

    return normalMark;
  }

  public AlternativeResultDto calculateMarks() {
    final var sumExpectedMarks = calculateSum();
    final var marks = calculateNormalMark(sumExpectedMarks);
    final var ranking = ranking(marks);
    return new AlternativeResultDto(marks, ranking);
  }

}
