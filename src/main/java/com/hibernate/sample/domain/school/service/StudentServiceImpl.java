package com.hibernate.sample.domain.school.service;

import com.hibernate.sample.domain.school.dto.StudentDto;
import com.hibernate.sample.domain.school.entity.CourseEntity;
import com.hibernate.sample.domain.school.entity.StudentEntity;
import com.hibernate.sample.domain.school.entity.SubjectEntity;
import com.hibernate.sample.domain.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public StudentDto createStudent(StudentDto student) {

        CourseEntity course = CourseEntity.builder()
                .name("Bachelor of Science in Information Technology")
                .build();

        StudentEntity studentEntity = StudentEntity.builder()
                .name(student.getName())
                .courseEntity(course)
                .build();

        studentEntity = studentRepository.save(studentEntity);
        return convertEntityToDto(studentEntity, null);

    }

    @Override
    public StudentDto getStudent(Long id) {
        StudentEntity found = studentRepository.findByid(id);
        List<CourseEntity> coursesFound = found.getCourse();
//        Used for OneToMany
//        CourseEntity courseFound = found.getCourseEntity();
        //------------------------
//        String courseFound = found.getCourseEntity().getName();
//        return convertEntityToDto(found, coursesFound);
        return convertEntityToDto(found, coursesFound);
    }


    private StudentDto convertEntityToDto(StudentEntity entity, List<CourseEntity> coursesEntity) {
        return StudentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .courses(coursesEntity)
                .build();
    }
}
