package org.example.entity9;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "cooks")
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int salary;

    public Cook(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
