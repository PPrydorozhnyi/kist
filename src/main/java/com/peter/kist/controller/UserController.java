package com.peter.kist.controller;

import com.peter.kist.model.dto.UserDTO;
import com.peter.kist.model.entity.User;
import com.peter.kist.service.SecurityService;
import com.peter.kist.service.UserService;
import com.peter.kist.validator.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    private final ModelMapper mapper;

    @Autowired
    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator, ModelMapper mapper) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
        this.mapper = mapper;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User user = mapper.map(userForm, User.class);

        userService.save(user);

        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
