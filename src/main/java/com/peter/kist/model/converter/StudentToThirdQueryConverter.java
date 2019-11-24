package com.peter.kist.model.converter;

import com.peter.kist.model.dto.ThirdQueryDTO;
import com.peter.kist.model.entity.PunishKind;
import com.peter.kist.model.entity.Student;
import com.peter.kist.model.entity.Violation;
import com.peter.kist.model.entity.ViolationKind;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentToThirdQueryConverter implements Converter<Student, ThirdQueryDTO> {


    @Override
    public ThirdQueryDTO convert(Student student){

        ThirdQueryDTO thirdQueryDTO = new ThirdQueryDTO();

        thirdQueryDTO.setName(student.getName());
        thirdQueryDTO.setSurname(student.getSurname());
        thirdQueryDTO.setSex(student.getSex());
        thirdQueryDTO.setTelephoneNumber(student.getTelephoneNumber());
        thirdQueryDTO.setViolationKindName(student.getViolations().stream().findAny().map(Violation::getPunishKind).map(PunishKind::getName).orElseGet(String::new));

        return thirdQueryDTO;
    }



}
