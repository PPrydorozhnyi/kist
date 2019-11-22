package com.peter.kist.service.impl;

import com.peter.kist.model.entity.PersonPrivilege;
import com.peter.kist.repository.PersonPrivilegeRepository;
import com.peter.kist.service.PersonPrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonPrivilegeServiceImpl implements PersonPrivilegeService {

    private final PersonPrivilegeRepository personPrivilegeRepository;

    @Override
    @Transactional
    public PersonPrivilege createPersonPrivilege(PersonPrivilege personPrivilege) {
        return personPrivilegeRepository.save(personPrivilege);
    }

    @Override
    @Transactional
    public PersonPrivilege editPersonPrivilege(PersonPrivilege personPrivilege) {
        return personPrivilegeRepository.save(personPrivilege);
    }

    @Override
    public PersonPrivilege getPersonPrivilege(Integer personId, Integer privilegeId) {
        return personPrivilegeRepository.findPersonPrivilegeByPersonIdAndPrivilegeId(personId, privilegeId);
    }

    @Override
    @Transactional
    public void deletePersonPrivilege(Integer personId, Integer privilegeId) {
        personPrivilegeRepository.deleteByPersonIdAndPrivilegeId(personId, privilegeId);
    }

    @Override
    public List<PersonPrivilege> findAll() {
        return personPrivilegeRepository.findAll();
    }

}
