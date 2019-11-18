package com.peter.kist.service;

import com.peter.kist.model.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    Order editOrder(Order order);

    Order getOrder(Integer id);

    void deleteOrder(Integer id);

    List<Order> findAll();
}
