package com.peter.kist.model.converter;

import com.peter.kist.model.dto.PersonPrivilegeDTO;
import com.peter.kist.model.entity.PersonPrivilege;
import com.peter.kist.repository.PrivilegeRepository;
import com.peter.kist.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonPrivilegeDtoToInstanceConverter implements Converter<PersonPrivilegeDTO, PersonPrivilege> {

    private final PersonRepository personRepository;

    private final PrivilegeRepository privilegeRepository;

    private final ModelMapper mapper;

    @Override
    public PersonPrivilege convert(PersonPrivilegeDTO personPrivilegeDTO) {

//        PersonPrivilege personPrivilege = new PersonPrivilege();
//
//        personPrivilege.setBeginDate(personPrivilegeDTO.getBeginDate());
//        personPrivilege.setEndDate(personPrivilegeDTO.getEndDate());
//        personPrivilege.setGround(personPrivilegeDTO.getGround());

        PersonPrivilege personPrivilege = mapper.map(personPrivilegeDTO, PersonPrivilege.class);

        personPrivilege.setPrivilege(privilegeRepository.getOne(personPrivilegeDTO.getPrivilege().getId()));
        personPrivilege.setPerson(personRepository.getOne(personPrivilegeDTO.getPerson().getId()));

        return personPrivilege;
    }
}
