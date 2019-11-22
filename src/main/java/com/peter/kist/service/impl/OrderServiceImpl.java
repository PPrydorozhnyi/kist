package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Order;
import com.peter.kist.repository.OrderRepository;
import com.peter.kist.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;
    
    @Override
    public Order createOrder(Order order) { return orderRepository.save(order); }

    @Override
    public Order editOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Integer id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}
