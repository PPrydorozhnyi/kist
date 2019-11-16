package com.peter.kist.controller;


import com.peter.kist.model.OrderKind;
import com.peter.kist.service.OrderKindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/order-kind")
public class OrderKindController {
    private final OrderKindService orderKindService;

    @GetMapping("/{id}")
    public String getOrderKind(Model model, @PathVariable Integer id) {

        log.debug("getOrderKind");

        OrderKind orderKind = orderKindService.getOrderKind(id);

        model.addAttribute("orderKindForm", orderKind);

        return "orderKindView";
    }

    @GetMapping("/create")
    public String createOrderKind(Model model) {

        log.debug("createOrderKind");

        OrderKind orderKind = new OrderKind();

        model.addAttribute("orderKindForm", orderKind);

        return "orderKindCreation";
    }

    @PostMapping("/create")
    public String createOrderKind(@ModelAttribute("orderKindForm") OrderKind orderKindForm, BindingResult bindingResult) {

        log.debug("OrderKind creation");

        orderKindService.createOrderKind(orderKindForm);

        return "redirect:/order-kind/" + orderKindForm.getId();
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("orderKindForm") OrderKind orderKind, Model model) {
        log.debug("editOrderKind");

        return "orderKindCreation";
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

        model.addAttribute("orderKind", orderKind);

        model.addAttribute("deletedUserName", null);

        return "orderKindTableView";
    }
}
