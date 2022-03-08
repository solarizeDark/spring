package ru.fedusiv.repositories;

import ru.fedusiv.entities.Student;

import java.util.List;

public interface StudentsRepository extends CRUDRepository<Student, Long> {

    List<Student> findAll();

}
