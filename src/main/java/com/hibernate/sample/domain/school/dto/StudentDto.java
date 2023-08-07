package com.hibernate.sample.domain.school.dto;


import lombok.*;
import org.springframework.lang.NonNull;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class StudentDto {

    private Long id;
    @NonNull
    private String name;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SingleStudent<T> {
        private T student;
    }

}
