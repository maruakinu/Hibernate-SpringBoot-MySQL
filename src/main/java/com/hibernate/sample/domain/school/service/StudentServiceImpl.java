package com.hibernate.sample.domain.school.service;

import com.hibernate.sample.domain.school.dto.StudentDto;
import com.hibernate.sample.domain.school.entity.CourseEntity;
import com.hibernate.sample.domain.school.entity.StudentEntity;
import com.hibernate.sample.domain.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public StudentDto createStudent(StudentDto student) {

        CourseEntity course = CourseEntity.builder()
                .name("Math")
                .build();

        StudentEntity studentEntity = StudentEntity.builder()
                .name(student.getName())
                .courseEntity(course)
                .build();



        studentEntity = studentRepository.save(studentEntity);
        return convertEntityToDto(studentEntity);

    }


    private StudentDto convertEntityToDto(StudentEntity entity) {
        return StudentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
