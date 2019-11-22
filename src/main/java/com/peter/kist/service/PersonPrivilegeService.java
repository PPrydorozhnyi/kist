package com.peter.kist.service;

import com.peter.kist.model.entity.PersonPrivilege;

import java.util.List;

public interface PersonPrivilegeService {

    PersonPrivilege createPersonPrivilege(PersonPrivilege personPrivilege);

    PersonPrivilege editPersonPrivilege(PersonPrivilege personPrivilege);

    PersonPrivilege getPersonPrivilege(Integer personId,  Integer privilegeId);

    void deletePersonPrivilege(Integer personId, Integer privilegeId);

    List<PersonPrivilege> findAll();
}
