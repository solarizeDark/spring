package ru.fedusiv.mappers;

import org.apache.ibatis.annotations.*;
import ru.fedusiv.entities.Car;
import ru.fedusiv.entities.Person;
import ru.fedusiv.entities.PhoneNumber;

import java.util.Set;

@Mapper
public interface PersonMapper {

    @Insert("insert into people(name, surname, patronymic)" +
            "values (#{name}, #{surname}, #{patronymic})")
    boolean save(Person person);

    @Select("select p.* from people p where p.id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "surname", column = "surname"),
            @Result(property = "patronymic", column = "patronymic"),
            @Result(property = "age", column = "age"),
            @Result(property = "numbers", javaType = Set.class,
                    column = "id", many=@Many(select = "phoneNumbersByPersonId")),
            @Result(property = "cars", javaType = Set.class,
                    column = "id", many=@Many(select = "carsByPersonId"))
    })
    Person getPersonById(Long id);

    @Select("select * from phone_numbers where person_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "personId", column = "person_id"),
            @Result(property = "number", column = "number")
    })
    Set<PhoneNumber> phoneNumbersByPersonId(Long id);

    @Select("select c.* from cars c join people_cars pc " +
            "on pc.car_id = c.id where pc.person_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "serialNumber", column = "serial_number"),
            @Result(property = "model", column = "model")
    })
    Set<Car> carsByPersonId(Long id);

}
