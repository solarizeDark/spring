package ru.fedusiv.repositories;

import org.springframework.jdbc.core.RowMapper;
import ru.fedusiv.entities.Student;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class StudentsRepositoryImpl implements StudentsRepository {


    //language=SQL
    private static String SQL_FIND_ALL = "select * from students;";

    private NamedParameterJdbcTemplate jdbcTemplate;

    public StudentsRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Student> studentRowMapper = (row, rowNum) ->
            Student.builder()
                    .id(row.getLong("id"))
                    .group(row.getLong("group"))
                    .name(row.getString("name"))
                    .surname(row.getString("surname"))
                    .build();

    @Override
    public Student save(Student entity) {
        return null;
    }

    @Override
    public Student findById(Long aLong) {
        return null;
    }

    @Override
    public Long update(Student entity) {
        return null;
    }

    @Override
    public Long delete(Student entity) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, studentRowMapper);
    }
}
