package ru.fedusiv.repositories.people;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import ru.fedusiv.entities.Person;

import java.util.Collection;

@org.springframework.stereotype.Repository
@Qualifier("brief")
public interface PersonRepositoryBrief extends Repository<Person, Long> {

    @Query("select name, surname from People p where p.surname = :surname")
    <T> Collection<T> findBySurname(@Param("surname") String surname, Class<T> type);

}
