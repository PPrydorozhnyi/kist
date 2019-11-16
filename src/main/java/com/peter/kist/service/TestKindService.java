package com.peter.kist.service;

import com.peter.kist.model.entity.TestKind;

import java.util.List;

public interface TestKindService {
    TestKind createTestKind(TestKind testKind);

    TestKind editTestKind(TestKind testKind);

    TestKind getTestKind(Integer id);

    void deleteTestKind(Integer id);

    List<TestKind> findAll();
}
