package ru.fedusiv.services;

import ru.fedusiv.dto.Bio;
import ru.fedusiv.entities.Student;
import ru.fedusiv.exceptions.NoEntityException;
import ru.fedusiv.exceptions.SaveException;

import java.util.List;
import java.util.Optional;

public interface StudentsService {

    List<Student> findAll();
    Student save(Bio bio) throws NoEntityException, SaveException;

}
