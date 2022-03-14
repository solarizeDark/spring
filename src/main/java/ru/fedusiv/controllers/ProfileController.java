package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.fedusiv.dto.Bio;
import ru.fedusiv.entities.Student;
import ru.fedusiv.exceptions.NoEntityException;
import ru.fedusiv.exceptions.SaveException;
import ru.fedusiv.services.StudentsService;

@Controller
public class ProfileController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/profile")
    public String profileGET() {
        return "profile";
    }

    @PostMapping("/profile")
    public ModelAndView profilePOST(Bio bio) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        try {
            studentsService.save(bio);
        } catch (NoEntityException | SaveException exception) {
            modelAndView.addObject("error", exception.getMessage());
        }
        return modelAndView;
    }

}
