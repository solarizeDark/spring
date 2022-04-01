package ru.fedusiv.repositories;

import ru.fedusiv.entities.Person;

import java.util.List;

public interface CustomMockPersonRepository {

    List<Person> findMockPeople();

}
