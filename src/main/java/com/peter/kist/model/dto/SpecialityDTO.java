package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialityDTO {

    private Integer id;

    private String name;

    private String shifr;

    private CafedraDTO cafedra;

    public SpecialityDTO(CafedraDTO cafedra) {
        this.cafedra = cafedra;
    }
}
