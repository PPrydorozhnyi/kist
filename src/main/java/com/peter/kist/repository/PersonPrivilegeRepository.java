package com.peter.kist.repository;

import com.peter.kist.model.entity.PersonPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface PersonPrivilegeRepository extends JpaRepository<PersonPrivilege, Integer> {

    PersonPrivilege findPersonPrivilegeByPersonIdAndPrivilegeId(Integer personId, Integer privilegeId);

    @Modifying
    @Transactional
    void deleteByPersonIdAndPrivilegeId(Integer personId, Integer privilegeId);
}
