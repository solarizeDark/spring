package ru.fedusiv.repositories;

import ru.fedusiv.entities.Person;

import java.util.Arrays;
import java.util.List;

public class CustomMockPersonRepositoryImpl implements CustomMockPersonRepository {
    @Override
    public List<Person> findMockPeople() {
        Person temp = Person.builder()
                .name("Mocky")
                .surname("Mockoff")
                .patronymic("Mockiuy")
                .age(20)
                .build();
        return List.of(temp);
    }
}
