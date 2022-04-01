package ru.fedusiv.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("phone_numbers")
public class PhoneNumber {

    @Id
    private Long id;

    private String number;

    private Long personId;

    public String toString() {
        return "<PhoneNumber " + this.number + " owner " + this.personId + ">";
    }

}
