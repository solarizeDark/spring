package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedusiv.dto.SignUpForm;
import ru.fedusiv.services.SignUpService;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping(value = "/signUp", produces = "text/plain;charset=UTF-8")
    public String signUpGET(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUpPOST(@Valid SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                if (Objects.requireNonNull(error.getCodes())[0].equals("signUpForm.UsernamePasswordNonEquality")) {
                    model.addAttribute("usernamePasswordEquality", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("signUpForm", form);
            return "sign_up";
        }
        signUpService.save(form);
        return "redirect:profile";
    }

}
