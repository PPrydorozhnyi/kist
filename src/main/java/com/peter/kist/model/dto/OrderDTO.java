package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends OrderShortDTO {

    private Date orderDate;

    private String orderText;

    private OrderKindDTO orderKind;

    public OrderDTO(OrderKindDTO orderKind){
        this.orderKind = orderKind;
    }
}
