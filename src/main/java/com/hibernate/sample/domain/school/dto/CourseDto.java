package com.hibernate.sample.domain.school.dto;

import com.hibernate.sample.domain.school.entity.CourseEntity;
import com.hibernate.sample.domain.school.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long id;
//    @NonNull
    private String name;

    private List<StudentEntity> students;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MultipleCourses {
        private List<CourseDto> courses;
    }
}
