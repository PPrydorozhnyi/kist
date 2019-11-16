package com.peter.kist.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PunishKindDTO {

    private Integer id;

    @Length(max = 50)
    private String name;

}
