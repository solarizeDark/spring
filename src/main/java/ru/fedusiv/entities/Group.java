package ru.fedusiv.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student monitor;

    @Temporal(TemporalType.DATE)
    private Date entranceDate;

    @Temporal(TemporalType.DATE)
    private Date graduateDate;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public String toString() {
        return this.getId();
    }

}
