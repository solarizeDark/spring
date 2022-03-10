package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedusiv.UserForm;
import ru.fedusiv.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String signUpGET() {
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUpPOST(UserForm form) {
        signUpService.save(form);
        return "profile";
    }

}
