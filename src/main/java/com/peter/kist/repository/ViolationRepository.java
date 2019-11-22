package com.peter.kist.repository;

import com.peter.kist.model.entity.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ViolationRepository extends JpaRepository<Violation, Integer> {
    @Modifying
    @Transactional
    void deleteViolationById(Integer id);
}
