package com.peter.kist.controller;


import com.peter.kist.model.dto.OrderKindDTO;
import com.peter.kist.model.entity.OrderKind;
import com.peter.kist.service.OrderKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.peter.kist.AppConstants.ORDER_KIND_LIST_TYPE;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/order-kind")
public class OrderKindController {

    private final ModelMapper mapper;

    private final OrderKindService orderKindService;

    @GetMapping("/{id}")
    public String getOrderKind(Model model, @PathVariable Integer id) {

        log.debug("getOrderKind");

        OrderKind orderKind = orderKindService.getOrderKind(id);

        model.addAttribute("orderKindForm", mapper.map(orderKind, OrderKindDTO.class));

        return "order-kind/orderKindView";
    }

    @GetMapping("/create")
    public String createOrderKind(Model model) {

        log.debug("createOrderKind");

        model.addAttribute("orderKindForm", new OrderKindDTO());

        return "order-kind/orderKindCreation";
    }

    @PostMapping("/create")
    public String createOrderKind(@ModelAttribute("orderKindForm") OrderKindDTO orderKindForm, BindingResult bindingResult) {

        log.debug("OrderKind creation");

        OrderKind orderKind = mapper.map(orderKindForm, OrderKind.class);

        orderKindService.createOrderKind(orderKind);

        return "redirect:/order-kind/" + orderKind.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("orderKindForm") OrderKindDTO orderKind, Model model) {
        log.debug("editOrderKind");

        return "order-kind/orderKindCreation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        log.debug("deleteOrderKind");

        orderKindService.deleteOrderKind(id);

        return "redirect:/order-kind/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {

        log.debug("findAllOrderKind");

        List<OrderKind> orderKind = orderKindService.findAll();

        model.addAttribute("orderKind", mapper.map(orderKind, ORDER_KIND_LIST_TYPE));

        return "order-kind/orderKindTableView";
    }
}
