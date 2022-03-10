package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.fedusiv.entities.Student;
import ru.fedusiv.services.StudentsService;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public ModelAndView studentsGET() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentsService.findAll());
        modelAndView.setViewName("students");
        studentsService.findAll().forEach(System.out::println);
        return modelAndView;
    }

}
