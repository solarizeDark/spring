package ru.fedusiv.dto;

import lombok.Builder;
import lombok.Data;
import ru.fedusiv.entities.Group;

@Data
@Builder
public class Bio {

    private String name;

    private String surname;

    private Integer age;

    private Group group;

}
