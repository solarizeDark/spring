package ru.fedusiv.services;

import ru.fedusiv.entities.Student;
import ru.fedusiv.repositories.StudentsRepository;

import java.util.List;

public class StudentsServiceImpl implements StudentsService {

    private StudentsRepository studentsRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentsRepository.findAll();
    }
}
