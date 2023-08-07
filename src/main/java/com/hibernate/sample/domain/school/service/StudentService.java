package com.hibernate.sample.domain.school.service;

import com.hibernate.sample.domain.school.dto.StudentDto;

public interface StudentService {

    StudentDto createStudent(final StudentDto student);

    StudentDto getStudent(final Long id);

}
