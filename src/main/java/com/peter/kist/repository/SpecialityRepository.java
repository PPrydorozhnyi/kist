package com.peter.kist.repository;

import com.peter.kist.model.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
    @Modifying
    @Transactional
    void deleteSpecialityById(Integer id);
}
