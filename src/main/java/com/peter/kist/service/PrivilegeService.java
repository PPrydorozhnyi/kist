package com.peter.kist.service;

import com.peter.kist.model.Privilege;

import java.util.List;

public interface PrivilegeService {
    Privilege createPrivilege(Privilege privilege);

    Privilege editPrivilege(Privilege privilege);

    Privilege getPrivilege(Integer id);

    void deletePrivilege(Integer id);

    List<Privilege> findAll();
}
