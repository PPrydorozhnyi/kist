package com.peter.kist.controller;

import com.peter.kist.model.dto.OrderDTO;
import com.peter.kist.model.dto.OrderKindDTO;
import com.peter.kist.model.entity.Order;
import com.peter.kist.model.entity.OrderKind;
import com.peter.kist.service.OrderKindService;
import com.peter.kist.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.peter.kist.AppConstants.ORDER_KIND_LIST_TYPE;
import static com.peter.kist.AppConstants.ORDER_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/order")
public class OrderController {

    private static final String ORDER_CREATION_PAGE = "orderCreation";

    private final OrderService orderService;

    private final OrderKindService orderKindService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public String getOrder(Model model, @PathVariable Integer id) {

        log.debug("getOrder");

        Order order = orderService.getOrder(id);

        model.addAttribute("orderForm", mapper.map(order, OrderDTO.class));

        return "order/orderView";
    }

    @GetMapping("/create")
    public String createOrder(Model model) {

        log.debug("createOrder");

        List<OrderKind> orderKinds = orderKindService.findAll();

        final Map<String, Object> map = Map.of("orderForm", new OrderDTO(new OrderKindDTO()),
                "orderKinds", mapper.map(orderKinds, ORDER_KIND_LIST_TYPE));

        model.addAllAttributes(map);

        return ORDER_CREATION_PAGE;
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute("orderForm") OrderDTO orderForm, BindingResult bindingResult) {

        log.debug("Order creation");

        Order order = conversionService.convert(orderForm, Order.class);

        if (bindingResult.hasErrors()) {
            return ORDER_CREATION_PAGE;
        }

        order = orderService.createOrder(order);

        return "redirect:/order/" + order.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("orderForm") OrderDTO order, Model model) {
        log.debug("editOrder");

        List<OrderKind> orderKinds = orderKindService.findAll();

        final Map<String, Object> map = Map.of("orderKinds", mapper.map(orderKinds, ORDER_KIND_LIST_TYPE));

        model.addAllAttributes(map);

        return ORDER_CREATION_PAGE;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteOrder");

        orderService.deleteOrder(id);

        return "redirect:/order/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllOrder");

        List<Order> orders = orderService.findAll();

        model.addAttribute("orders", mapper.map(orders, ORDER_LIST_TYPE));

        return "order/orderTableView";
    }
}

