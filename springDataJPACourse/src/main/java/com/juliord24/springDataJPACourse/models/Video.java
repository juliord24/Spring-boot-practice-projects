package com.juliord24.springDataJPACourse.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Polymorphism(type = PolymorphismType.EXPLICIT) deprected
//@PrimaryKeyJoinColumn(name = "video_id")
//@DiscriminatorValue("V")
public class Video extends Resource {

    private int length;

}
