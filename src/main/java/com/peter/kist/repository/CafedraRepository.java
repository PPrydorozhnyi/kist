package com.peter.kist.repository;

import com.peter.kist.model.entity.Cafedra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface CafedraRepository extends JpaRepository<Cafedra, Integer> {
    @Modifying
    @Transactional
    void deleteCafedraById(Integer id);
}
