package com.peter.kist.model.dto.third;

import lombok.Data;

import java.util.List;

@Data
public class LaplaceInputDto {

    private List<Double> inputValues;
    private Integer amountOfAlternative;
    private Integer amountOfCondition;

}
