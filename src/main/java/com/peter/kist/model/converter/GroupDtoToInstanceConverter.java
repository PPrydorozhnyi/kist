package com.peter.kist.model.converter;

import com.peter.kist.model.dto.GroupDTO;
import com.peter.kist.model.entity.Group;
import com.peter.kist.repository.SpecialityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GroupDtoToInstanceConverter implements Converter<GroupDTO, Group> {

    private final SpecialityRepository specialityRepository;

    private final ModelMapper mapper;

    @Override
    public Group convert(GroupDTO groupDTO) {

        Group group = mapper.map(groupDTO, Group.class);

        group.setSpeciality(specialityRepository.getOne(groupDTO.getSpeciality().getId()));

        return group;
    }
}
