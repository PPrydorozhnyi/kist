package com.peter.kist.model.converter;

import com.peter.kist.model.dto.SpecialityDTO;
import com.peter.kist.model.entity.Speciality;
import com.peter.kist.repository.CafedraRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SpecialityDtoToInstanceConverter implements Converter<SpecialityDTO, Speciality> {

    private final CafedraRepository cafedraRepository;

    private final ModelMapper mapper;

    @Override
    public Speciality convert(SpecialityDTO specialityDTO){

        Speciality speciality = mapper.map(specialityDTO, Speciality.class);

        speciality.setCafedra(cafedraRepository.getOne(specialityDTO.getCafedra().getId()));

        return speciality;
    }
}
