package ru.fedusiv.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("people")
public class Person {

    @Id
    private Long id;

    private String name;

    private String surname;

    private String patronymic;

    private Integer age;

    private Set<PhoneNumber> numbers = new HashSet<>();

    private Set<Car> cars = new HashSet<>();

    @Override
    public String toString() {
        return "<Person: " + this.id + " " + this.name + " " + this.age + ">";
    }

}

