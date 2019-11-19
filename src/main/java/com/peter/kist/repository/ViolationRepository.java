package com.peter.kist.repository;

import com.peter.kist.model.entity.Violation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViolationRepository extends JpaRepository<Violation, Integer> {
}
