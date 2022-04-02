package ru.fedusiv.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import ru.fedusiv.dto.PersonDto;
import ru.fedusiv.entities.Person;

import java.util.Collection;

@org.springframework.stereotype.Repository
@Qualifier("brief")
public interface PersonRepositoryBrief extends Repository<Person, Long> {

    <T> Collection<T> findBySurname(@Param("surname") String surname, Class<T> type);

}
