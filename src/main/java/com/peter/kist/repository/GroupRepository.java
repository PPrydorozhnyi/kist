package com.peter.kist.repository;

import com.peter.kist.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Modifying
    @Transactional
    void deleteGroupById(Integer id);
}
