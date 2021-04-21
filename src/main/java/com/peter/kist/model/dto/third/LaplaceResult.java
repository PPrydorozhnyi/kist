package com.peter.kist.model.dto.third;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LaplaceResult {

    private List<Double> savageResult;
    private List<Double> laplaceResult;

    private int[] savageRank;
    private int[] laplaceRank;

}
