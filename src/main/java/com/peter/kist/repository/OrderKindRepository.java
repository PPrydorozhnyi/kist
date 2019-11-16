package com.peter.kist.repository;

import com.peter.kist.model.OrderKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderKindRepository extends JpaRepository<OrderKind, Integer> {
}
