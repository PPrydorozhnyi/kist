package com.peter.kist.repository;

import com.peter.kist.model.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
    @Modifying
    @Transactional
    void deletePrivilegeById(Integer id);
}
