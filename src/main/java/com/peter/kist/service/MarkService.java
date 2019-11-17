package com.peter.kist.service;

import com.peter.kist.model.entity.Mark;

import java.util.List;

public interface MarkService {
    Mark createMark(Mark mark);

    Mark editMark(Mark mark);

    Mark getMark(Integer id);

    void deleteMark(Integer id);

    List<Mark> findAll();
}
