package ru.fedusiv.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    Long id;
    String name;
    String surname;
    Long group;

}
