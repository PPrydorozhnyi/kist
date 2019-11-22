package com.peter.kist.repository;

import com.peter.kist.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Modifying
    @Transactional
    void deleteOrderById(Integer id);
}
