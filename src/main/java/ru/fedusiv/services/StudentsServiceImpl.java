package ru.fedusiv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.fedusiv.entities.Student;
import ru.fedusiv.repositories.StudentsRepository;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    @Qualifier(value = "main")
    private StudentsRepository studentsRepository;

    @Override
    public List<Student> findAll() {
        return studentsRepository.findAll();
    }
}
