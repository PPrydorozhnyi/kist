package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViolationDTO {
    private Integer id;
    private Date violationDate;

    private PersonShortDTO person;
    private OrderShortDTO order;
    private ViolationKindDTO violationKind;
    private PunishKindDTO punishKind;

    public ViolationDTO(PersonShortDTO person, OrderShortDTO order, ViolationKindDTO violationKind, PunishKindDTO punishKind){
        this.person = person;
        this.order = order;
        this.violationKind = violationKind;
        this.punishKind = punishKind;
    }
}
