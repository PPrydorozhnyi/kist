package com.peter.kist.model.dto.second;

import java.util.List;
import lombok.Data;

@Data
public class GurvicInputDto {

  private List<Double> inputValues;
  private Integer amountOfSolving;
  private Integer amountOfStage;

}
