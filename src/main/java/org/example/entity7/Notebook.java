package org.example.entity7;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
 @Table(name = "notebooks")
class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;

    public Notebook(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
