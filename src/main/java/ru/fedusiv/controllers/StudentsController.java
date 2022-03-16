package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.fedusiv.entities.Group;
import ru.fedusiv.entities.Student;
import ru.fedusiv.exceptions.NoEntityException;
import ru.fedusiv.services.GroupsService;
import ru.fedusiv.services.StudentsService;

import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private GroupsService groupsService;

    @GetMapping(value = "/students",
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "studentId")
    @ResponseBody
    public Student getStudentByIdGET(@RequestParam("studentId") Long studentId) {
        return studentsService.getStudentById(studentId);
    }

    @GetMapping(value = "/students", params = "{!groupId, !studentId}")
    public ModelAndView studentsGET() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentsService.findAll());
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @GetMapping(value = "/students",
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = "groupId")
    @ResponseBody
    public List<Student> getAllStudentsByGroup (
            @RequestParam(value = "groupId") String groupId) {
        try {
            Group group = groupsService.getGroupById(groupId);
            List<Student> students = group.getStudents();
            return group.getStudents();
        } catch (NoEntityException exception) {
            throw new IllegalArgumentException(exception);
        }
    }

}
