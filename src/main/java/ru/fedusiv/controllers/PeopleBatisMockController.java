package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fedusiv.entities.Car;
import ru.fedusiv.entities.Person;
import ru.fedusiv.entities.PhoneNumber;
import ru.fedusiv.mappers.PersonMapper;

import java.util.Set;

@Controller
@RequestMapping("/batis")
public class PeopleBatisMockController {

    private final PersonMapper personMapper;

    @Autowired
    public PeopleBatisMockController(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @GetMapping("/person/{id}")
    public void getPersonById(@PathVariable("id") Long id) {
        Person p = personMapper.getPersonById(id);

        Set<PhoneNumber> phoneNumberSet = personMapper.phoneNumbersByPersonId(id);

        Set<Car> cars = personMapper.carsByPersonId(id);

        p.getNumbers().forEach(System.out::println);

        p.getCars().forEach(System.out::println);
    }

}
