package com.peter.kist.service.impl;

import com.peter.kist.model.entity.Cafedra;
import com.peter.kist.repository.CafedraRepository;
import com.peter.kist.service.CafedraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CafedraServiceImpl implements CafedraService {

    private final CafedraRepository cafedraRepository;

    @Override
    public Cafedra createCafedra(Cafedra cafedra) {
        return cafedraRepository.save(cafedra);
    }

    @Override
    public Cafedra editCafedra(Cafedra cafedra) {
        return cafedraRepository.save(cafedra);
    }

    @Override
    public Cafedra getCafedra(Integer id) {
        return cafedraRepository.getOne(id);
    }

    @Override
    public void deleteCafedra(Integer id) {
        Cafedra cafedra = cafedraRepository.getOne(id);
        cafedraRepository.delete(cafedra);
    }

    @Override
    public List<Cafedra> findAll() {
        return cafedraRepository.findAll();
    }
}
