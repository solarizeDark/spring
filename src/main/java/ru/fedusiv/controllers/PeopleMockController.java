package ru.fedusiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.fedusiv.dto.PersonDto;
import ru.fedusiv.entities.Person;
import ru.fedusiv.repositories.cars.CarsRepository;
import ru.fedusiv.repositories.people.PersonRepository;
import ru.fedusiv.repositories.people.PersonRepositoryBrief;
import ru.fedusiv.repositories.phones.PhoneNumbersRepository;

@Controller
@RequestMapping("/people")
public class PeopleMockController {

    @Autowired
    private PersonRepositoryBrief peopleRepositoryBrief;

    @Autowired
    private PersonRepository peopleRepository;

    @Autowired
    private CarsRepository carsRepository;

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

    @GetMapping("/get.top.2.name/{name}")
    public void getTop2ByAge(@PathVariable("name") String name) {
        peopleRepository.findTop2ByName(name).forEach(System.out::println);
    }

    @GetMapping("/get.mocked.people")
    public void getMockedPeople() {
        peopleRepository.findMockPeople().forEach(System.out::println);
    }

    @PostMapping("/new")
    public void addNewPerson(@RequestParam String name, @RequestParam String surname,
                             @RequestParam String patronymic, @RequestParam Integer age) {
        Person np = Person.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .patronymic(patronymic)
                .build();
        peopleRepository.save(np);

        System.out.println(np.getId());
    }

    @GetMapping("/get.phone.number/{id}")
    public void getPersonPhoneNumbers(@PathVariable("id") Long id) {
        peopleRepository.findById(id)
                .ifPresent(person -> person.getNumbers().forEach(System.out::println));
    }

    @GetMapping("/get.all.only.names/{surname}")
    public void getAllOnlyNames(@PathVariable("surname") String surname) {
        peopleRepositoryBrief.findBySurname(surname, PersonDto.class).forEach(System.out::println);
        System.out.println();
    }

    @GetMapping("/get.cars/{id}")
    public void getAllCarsForPerson(@PathVariable("id") Long personId) {
        carsRepository.getAllByOwner(personId).forEach(System.out::println);
    }

    // get all owners of car by car id
    @GetMapping("/get.owners/{id}")
    public void getAllOwners(@PathVariable("id") Long id) {
        peopleRepository.getAllByCarId(id).forEach(System.out::println);
    }

}
