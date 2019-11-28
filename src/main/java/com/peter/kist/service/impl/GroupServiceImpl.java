package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Group;
import com.peter.kist.repository.GroupRepository;
import com.peter.kist.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public Group createGroup(Group group) {
        if (group.getId() != null) {
            group = updateGroup(group);
        }
        return groupRepository.save(group);
    }

    @Override
    public Group editGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroup(Integer id) {
        return groupRepository.getOne(id);
    }

    @Override
    public void deleteGroup(Integer id) {
        groupRepository.deleteGroupById(id);
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    private Group updateGroup(Group group) {
        Group groupFromCache = groupRepository.getOne(group.getId());
        BeanUtils.copyProperties(group, groupFromCache, "id", "teacherPlans",
                "studentGroups", "speciality");
        return groupFromCache;
    }

}
