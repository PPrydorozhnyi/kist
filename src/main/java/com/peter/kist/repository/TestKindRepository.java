package com.peter.kist.repository;

import com.peter.kist.model.entity.TestKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestKindRepository extends JpaRepository<TestKind, Integer> {
}
