package com.peter.kist.model.dto.first;

import java.util.List;
import lombok.Data;

@Data
public class InputDto {

  private List<Integer> inputValues;
  private int amountOfAlternative;
  private int amountOfExpert;

}
