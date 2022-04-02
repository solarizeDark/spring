package ru.fedusiv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@Table("people_cars")
public class CarRef {

    private Long carId;

}
