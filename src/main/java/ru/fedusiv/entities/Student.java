package ru.fedusiv.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import ru.fedusiv.json.TemplateJsonSerializer;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
@JsonSerialize(using = TemplateJsonSerializer.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String surname;

    Integer age;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}

