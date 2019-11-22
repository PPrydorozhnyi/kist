package com.peter.kist.repository;

import com.peter.kist.model.entity.ViolationKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ViolationKindRepository extends JpaRepository<ViolationKind, Integer> {
    @Modifying
    @Transactional
    void deleteViolationKindById(Integer id);
}

