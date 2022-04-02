package ru.fedusiv.repositories.people;

import ru.fedusiv.entities.Person;

import java.util.List;

public interface CustomMockPersonRepository {

    List<Person> findMockPeople();

}
