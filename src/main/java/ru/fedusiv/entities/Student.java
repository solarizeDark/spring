package ru.fedusiv.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
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

