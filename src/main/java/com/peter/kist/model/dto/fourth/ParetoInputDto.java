package com.peter.kist.model.dto.fourth;

import java.util.List;
import lombok.Data;

@Data
public class ParetoInputDto {

    private List<String> inputValues;
    private int amountOfAlternatives;
    private int amountOfExperts;

}
