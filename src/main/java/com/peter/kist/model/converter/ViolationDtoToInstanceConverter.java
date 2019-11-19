package com.peter.kist.model.converter;

import com.peter.kist.model.dto.ViolationDTO;
import com.peter.kist.model.entity.Violation;
import com.peter.kist.repository.OrderRepository;
import com.peter.kist.repository.PersonRepository;
import com.peter.kist.repository.PunishKindRepository;
import com.peter.kist.repository.ViolationKindRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ViolationDtoToInstanceConverter implements Converter<ViolationDTO, Violation> {

    private final PersonRepository personRepository;

    private final OrderRepository orderRepository;

    private final ViolationKindRepository violationKindRepository;

    private final PunishKindRepository punishKindRepository;

    private final ModelMapper mapper;

    @Override
    public Violation convert(ViolationDTO violationDTO) {

        Violation violation = mapper.map(violationDTO, Violation.class);

        violation.setPerson(personRepository.getOne(violationDTO.getPerson().getId()));
        violation.setOrder(orderRepository.getOne(violationDTO.getOrder().getId()));
        violation.setViolationKind(violationKindRepository.getOne(violationDTO.getViolationKind().getId()));
        violation.setPunishKind(punishKindRepository.getOne(violationDTO.getPunishKind().getId()));

        return violation;
    }
}
