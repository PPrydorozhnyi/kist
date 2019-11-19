package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SpecialityDTO extends SpecialityShortDTO{

    private String shifr;

    private CafedraDTO cafedra;

    public SpecialityDTO(CafedraDTO cafedra) {
        this.cafedra = cafedra;
    }
}
