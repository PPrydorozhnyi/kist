package com.peter.kist.service;

import com.peter.kist.model.OrderKind;

import java.util.List;

public interface OrderKindService {
    OrderKind createOrderKind(OrderKind orderKind);

    OrderKind editOrderKind(OrderKind orderKind);

    OrderKind getOrderKind(Integer id);

    void deleteOrderKind(Integer id);

    List<OrderKind> findAll();
}
