package com.juliord24.springDataJPACourse.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQuery(
        name = "Author.findByNameQuery",
        query = "select a from Author a where = a.age >= :age"
)
//@Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity {

    /*@Id
    @GeneratedValue
            (
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )
    //Así creamos una sequence personalizada
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    //y asi una table personalizada
    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            pkColumnValue = "id_value",
            allocationSize = 1
    )
    private Integer id;*/
    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = false,
            nullable = false
    )
    private String email;
    private int age;

    @Column(
            updatable = false
    )
    private LocalDateTime createdAt;

    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;
    //la clase course es la owner de la relacion asique en esta es en la que ponemos el mappedBy

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;



}
