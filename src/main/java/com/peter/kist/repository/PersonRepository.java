package com.peter.kist.repository;

import com.peter.kist.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Modifying
    @Transactional
    void deletePersonById(Integer id);
}
