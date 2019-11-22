package com.peter.kist.repository;

import com.peter.kist.model.entity.PersonPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonPrivilegeRepository extends JpaRepository<PersonPrivilege, Integer> {

    public PersonPrivilege findPersonPrivilegeByPersonIdAndPrivilegeId(Integer personId, Integer privilegeId);

    public void deleteByPersonIdAndPrivilegeId(Integer personId, Integer privilegeId);
}
