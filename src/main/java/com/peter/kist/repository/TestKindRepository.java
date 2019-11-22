package com.peter.kist.repository;

import com.peter.kist.model.entity.TestKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface TestKindRepository extends JpaRepository<TestKind, Integer> {
    @Modifying
    @Transactional
    void deleteTestKindById(Integer id);
}
