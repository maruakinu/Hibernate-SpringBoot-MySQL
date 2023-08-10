package com.hibernate.sample.domain.school.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "course")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
//    @JsonManagedReference
//    private List<SubjectEntity> subject;

    // BiDirectional
    // OnetoOne means one student has one course
    // fetch = FetchType.LAZY -> This will help to retrieve another related entity when needed
    // mappedBy = "courseEntity" -> This means that the owning table is the Student and not Course
    // There is no id of student in course table
    // @JsonManagedReference is used to annotate the inverse side

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "courseEntity")
//    @JsonManagedReference
//    private StudentEntity studentEntity;


    @Builder
    public CourseEntity(String name) {
        this.name = name;
    }
}
