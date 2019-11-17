package com.peter.kist.repository;

import com.peter.kist.model.entity.ViolationKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationKindRepository extends JpaRepository<ViolationKind, Integer> {
}

