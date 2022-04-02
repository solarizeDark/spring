package ru.fedusiv.repositories.cars;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import ru.fedusiv.entities.Car;

import java.util.Set;

@org.springframework.stereotype.Repository
public interface CarsRepository extends Repository<Car, Long> {

    @Query("select cars.* from cars join people_cars on cars.id = people_cars.car_id " +
            "where person_id = :id")
    Set<Car> getAllByOwner(@Param("id") Long ownerId);

}
