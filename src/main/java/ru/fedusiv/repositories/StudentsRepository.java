package ru.fedusiv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.fedusiv.entities.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {


}
