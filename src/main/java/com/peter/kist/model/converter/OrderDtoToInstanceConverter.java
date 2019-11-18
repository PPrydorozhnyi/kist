package com.peter.kist.model.converter;

import com.peter.kist.model.dto.OrderDTO;
import com.peter.kist.model.entity.Order;
import com.peter.kist.repository.OrderKindRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderDtoToInstanceConverter implements Converter<OrderDTO, Order> {

    private final OrderKindRepository orderKindRepository;

    private final ModelMapper mapper;

    @Override
    public Order convert(OrderDTO orderDTO){

        Order order = mapper.map(orderDTO, Order.class);

        order.setOrderKind(orderKindRepository.getOne(orderDTO.getOrderKind().getId()));

        return order;
    }

}
