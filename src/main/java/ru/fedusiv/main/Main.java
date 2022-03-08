package ru.fedusiv.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zaxxer.hikari.HikariConfig;
import ru.fedusiv.entities.Student;
import ru.fedusiv.repositories.StudentsRepositoryImpl;
import ru.fedusiv.services.StudentsService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
        StudentsService studentsService = context.getBean("studentsService", ru.fedusiv.services.StudentsServiceImpl.class);
        List<Student> studentList = studentsService.findAll();
        studentList.forEach(System.out::println);

    }

}
