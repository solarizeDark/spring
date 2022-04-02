package ru.fedusiv.repositories.phones;

import org.springframework.data.repository.Repository;
import ru.fedusiv.entities.PhoneNumber;

import java.util.List;

@org.springframework.stereotype.Repository
public interface PhoneNumbersRepository extends Repository<PhoneNumber, Long> {

    List<PhoneNumber> findAllByPersonId(Long id);

}
