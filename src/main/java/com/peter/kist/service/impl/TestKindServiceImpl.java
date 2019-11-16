package com.peter.kist.service.impl;

import com.peter.kist.model.entity.TestKind;
import com.peter.kist.repository.TestKindRepository;
import com.peter.kist.service.TestKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestKindServiceImpl implements TestKindService {

    private final TestKindRepository testKindRepository;

    @Override
    public TestKind createTestKind(TestKind testKind) {
        return testKindRepository.save(testKind);
    }

    @Override
    public TestKind editTestKind(TestKind testKind) {
        return testKindRepository.save(testKind);
    }

    @Override
    public TestKind getTestKind(Integer id) {
        return testKindRepository.getOne(id);
    }

    @Override
    public void deleteTestKind(Integer id) {
        TestKind testKind = testKindRepository.getOne(id);
        testKindRepository.delete(testKind);
    }

    @Override
    public List<TestKind> findAll() {
        return testKindRepository.findAll();
    }

    /*@Override
    public List<Group> getGroupsForTestKind(Integer id) {
        TestKind testKind = testKindRepository.getOne(id);
        return testKind.getGroups();
    }*/
}
