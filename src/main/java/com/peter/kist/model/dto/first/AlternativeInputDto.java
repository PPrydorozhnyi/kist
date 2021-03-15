package com.peter.kist.model.dto.first;

import java.util.List;
import lombok.Data;

@Data
public class AlternativeInputDto {

  private List<Integer> inputValues;
  private int amountOfAlternative;
  private int amountOfExpert;

}
