package com.peter.kist.service;

import com.peter.kist.model.entity.Group;

import java.util.List;

public interface GroupService {

    Group createGroup(Group group);

    Group editGroup(Group group);

    Group getGroup(Integer id);

    void deleteGroup(Integer id);

    List<Group> findAll();
}
