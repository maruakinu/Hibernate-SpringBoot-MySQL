package com.hibernate.sample.domain.school.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    // OnetoOne Relationship
    // This will add a foreign key to Student Table
    // The foreign key will be the course id because we fetch the course entity
    // Simply put, whoever owns the foreign key column gets the @JoinColumn annotation.
    // name = "course_id" -> If we don't provide a name, Hibernate will follow some rules to select a default one.
    // @JsonBackReference maps the owning side of the relationship.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
//    @JsonBackReference
    private CourseEntity courseEntity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "subject_student",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") })
    private List<CourseEntity> courseEntities;

    @Builder
    public StudentEntity(Long id, String name, CourseEntity courseEntity) {
        this.id = id;
        this.name = name;
        this.courseEntity = courseEntity;
    }
}
