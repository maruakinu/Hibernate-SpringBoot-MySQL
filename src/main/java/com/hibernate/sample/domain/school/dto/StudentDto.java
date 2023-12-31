package com.hibernate.sample.domain.school.dto;


import com.hibernate.sample.domain.school.entity.CourseEntity;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class StudentDto {

    private Long id;
    @NonNull
    private String name;

    private List<CourseEntity> courses;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SingleStudent<T> {
        private T student;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MultipleStudents {
        private List<StudentDto> students;
    }

}
