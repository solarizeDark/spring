package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fedusiv.entities.Person;
import ru.fedusiv.repositories.PersonRepository;

@Controller
@RequestMapping("/people")
public class PeopleMockController {

    @Autowired
    private PersonRepository peopleRepository;

    @GetMapping("/getAll")
    public void getAll() {
        peopleRepository.findAll().forEach(System.out::println);
    }

    @GetMapping("/get/{surname}")
    public void getBySurname(@PathVariable("surname") String surname) {
        peopleRepository.findBySurnameIgnoreCase(surname.toUpperCase())
                .ifPresent(System.out::println);
    }

    @GetMapping("/getAll/names.sorted.ascending/{name}")
    public void getAllByNameSortedAscending(@PathVariable("name") String name) {

        peopleRepository.getAllByName(name, peopleRepository.sort)
                .forEach(System.out::println);
    }

}
