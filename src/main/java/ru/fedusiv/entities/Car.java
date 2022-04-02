package ru.fedusiv.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("cars")
public class Car {

    @Id
    private Long id;

    private String serialNumber;

    private String model;

    public String toString() {
        return "<Car " + this.getSerialNumber() + " " + this.getModel() + ">";
    }

}
