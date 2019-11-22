package com.peter.kist.repository;

import com.peter.kist.model.entity.OrderKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface OrderKindRepository extends JpaRepository<OrderKind, Integer> {
    @Modifying
    @Transactional
    void deleteOrderKindById(Integer id);
}
