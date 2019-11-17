package com.peter.kist.service;

import com.peter.kist.model.entity.Cafedra;

import java.util.List;

public interface CafedraService {
    Cafedra createCafedra(Cafedra cafedra);

    Cafedra editCafedra(Cafedra cafedra);

    Cafedra getCafedra(Integer id);

    void deleteCafedra(Integer id);

    List<Cafedra> findAll();
}
