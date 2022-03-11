package ru.fedusiv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fedusiv.dto.Bio;

import java.security.Principal;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profileGET() {
        return "profile";
    }

    @PostMapping("profile")
    public void profilePOST(Principal principal, Bio bio) {
        String userName = principal.getName();
    }

}
