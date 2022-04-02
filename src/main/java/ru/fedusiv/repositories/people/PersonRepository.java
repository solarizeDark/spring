package ru.fedusiv.repositories.people;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.fedusiv.entities.Person;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@Qualifier("extended")
public interface PersonRepository extends TemplateRepository<Person, Long>, CustomMockPersonRepository {

    Sort.TypedSort<Person> person = Sort.sort(Person.class);

    Sort sort = person.by(Person::getAge).descending();

    Optional<Person> findBySurnameIgnoreCase(String surname);
    List<Person> getAllByName(String name, Sort sort);
    List<Person> findTop2ByName(String name);

    @Query("select people.* from people " +
            "join people_cars on people_cars.person_id = people.id " +
            "where car_id = :id")
    Set<Person> getAllByCarId(@Param("id") Long id);

}
