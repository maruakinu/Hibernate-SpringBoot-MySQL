package com.hibernate.sample.domain.school.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity courseEntity;

    @Builder
    public StudentEntity(Long id, String name, CourseEntity courseEntity) {
        this.id = id;
        this.name = name;
        this.courseEntity = courseEntity;
    }
}
