package com.peter.kist.service.impl;

import com.peter.kist.model.Group;
import com.peter.kist.model.Privilege;
import com.peter.kist.repository.PrivilegeRepository;
import com.peter.kist.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PrivilegeServiceImpl implements PrivilegeService {

    private final PrivilegeRepository privilegeRepository;

    @Override
    public Privilege createPrivilege(Privilege privilege) {
        if (privilege.getId() != null) {
            privilege = updatePrivilege(privilege);
        }
        return privilegeRepository.save(privilege);
    }

    @Override
    public Privilege editPrivilege(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    @Override
    public Privilege getPrivilege(Integer id) {
        return privilegeRepository.getOne(id);
    }

    @Override
    public void deletePrivilege(Integer id) {
        Privilege privilege = privilegeRepository.getOne(id);
        privilegeRepository.delete(privilege);
    }

    @Override
    public List<Privilege> findAll() {
        return privilegeRepository.findAll();
    }

    private Privilege updatePrivilege(Privilege privilege) {
        Privilege privilegeFromCache = privilegeRepository.getOne(privilege.getId());
        BeanUtils.copyProperties(privilege, privilegeFromCache, "id", "personPrivilege");
        return privilegeFromCache;
    }

    /*@Override
    public List<Group> getGroupsForPrivilege(Integer id) {
        Privilege privilege = privilegeRepository.getOne(id);
        return privilege.getGroups();
    }*/
}
