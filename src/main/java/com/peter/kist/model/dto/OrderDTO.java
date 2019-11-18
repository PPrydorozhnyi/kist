package com.peter.kist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private Integer orderNo;
    private Date orderDate;
    private String orderText;

    private OrderKindDTO orderKind;

    public OrderDTO(OrderKindDTO orderKind){
        this.orderKind = orderKind;
    }
}
