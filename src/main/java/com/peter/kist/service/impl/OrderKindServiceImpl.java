package com.peter.kist.service.impl;

import com.peter.kist.model.OrderKind;
import com.peter.kist.repository.OrderKindRepository;
import com.peter.kist.service.OrderKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderKindServiceImpl implements OrderKindService {
    private final OrderKindRepository orderKindRepository;

    @Override
    public OrderKind createOrderKind(OrderKind orderKind) {
        return orderKindRepository.save(orderKind);
    }

    @Override
    public OrderKind editOrderKind(OrderKind orderKind) {
        return orderKindRepository.save(orderKind);
    }

    @Override
    public OrderKind getOrderKind(Integer id) {
        return orderKindRepository.getOne(id);
    }

    @Override
    public void deleteOrderKind(Integer id) {
        OrderKind orderKind = orderKindRepository.getOne(id);
        orderKindRepository.delete(orderKind);
    }

    @Override
    public List<OrderKind> findAll() {
        return orderKindRepository.findAll();
    }
}

