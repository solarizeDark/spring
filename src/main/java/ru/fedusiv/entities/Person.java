package ru.fedusiv.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

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

    @MappedCollection(idColumn = "person_id")
    private Set<PhoneNumber> numbers;

    @Override
    public String toString() {
        return "<Person: " + this.id + " " + this.name + " " + this.age + ">";
    }

}

