package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Mark;
import com.peter.kist.repository.MarkRepository;
import com.peter.kist.service.MarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;

    @Override
    public Mark createMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Mark editMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Mark getMark(Integer id) {
        return markRepository.getOne(id);
    }

    @Override
    public void deleteMark(Integer id) {
        Mark mark = markRepository.getOne(id);
        markRepository.delete(mark);
    }

    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }

}

