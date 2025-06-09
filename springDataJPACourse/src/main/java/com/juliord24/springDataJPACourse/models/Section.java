package com.juliord24.springDataJPACourse.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Section extends BaseEntity {
    private String name;
    private int sectionOrder;

    //many to one hay que crear una columna para referenciar
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    //one to many hay que indicar que columna referencia
    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

}
