package ru.fedusiv.repositories.people;

import ru.fedusiv.entities.Person;

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
