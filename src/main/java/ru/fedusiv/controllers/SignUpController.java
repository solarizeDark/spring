package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedusiv.dto.SignUpForm;
import ru.fedusiv.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping(value = "/signUp", produces = "text/plain;charset=UTF-8")
    public String signUpGET() {
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUpPOST(SignUpForm form) {
        signUpService.save(form);
        return "profile";
    }

}
