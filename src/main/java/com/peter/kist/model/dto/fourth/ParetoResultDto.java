package com.peter.kist.model.dto.fourth;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class ParetoResultDto {
    private Map<String, List<Integer>> rankedMap;
    private Set<String> pareto;
}
