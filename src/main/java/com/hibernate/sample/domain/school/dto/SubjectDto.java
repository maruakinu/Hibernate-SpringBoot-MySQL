package com.hibernate.sample.domain.school.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hibernate.sample.domain.school.entity.CourseEntity;
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
public class SubjectDto {

    private Long id;
    @NonNull
    private String name;

    private CourseEntity course;


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MultipleSubjects {
        private List<SubjectDto> subjects;
    }

}
