package ru.fedusiv.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.fedusiv.entities.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends TemplateRepository<Person, Long> {

    Sort.TypedSort<Person> person = Sort.sort(Person.class);

    Sort sort = person.by(Person::getAge).descending();

    Optional<Person> findBySurnameIgnoreCase(String surname);
    List<Person> getAllByName(String name, Sort sort);

}
