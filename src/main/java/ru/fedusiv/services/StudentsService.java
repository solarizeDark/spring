package ru.fedusiv.services;

import ru.fedusiv.entities.Student;

import java.util.List;

public interface StudentsService {

    List<Student> findAll();

}
