package com.hibernate.sample.domain.school.service;

import com.hibernate.sample.domain.school.dto.CourseDto;
import com.hibernate.sample.domain.school.dto.StudentDto;
import com.hibernate.sample.domain.school.dto.SubjectDto;
import com.hibernate.sample.domain.school.entity.CourseEntity;
import com.hibernate.sample.domain.school.entity.StudentEntity;
import com.hibernate.sample.domain.school.entity.SubjectEntity;
import com.hibernate.sample.domain.school.repository.CourseRepository;
import com.hibernate.sample.domain.school.repository.StudentRepository;
import com.hibernate.sample.domain.school.repository.SubjectRepository;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;


//    @Override
//    public List<SubjectDto> getSubjectByCourseId(Long id) {
//        Long courseId = courseRepository.findByid(id).getId();
//        List<SubjectEntity> subjectEntities = subjectRepository.findByCourseId(courseId);
//        return subjectEntities.stream().map(subjectEntity -> convertToDTO(subjectEntity)).collect(Collectors.toList());
//    }

    @Override
    public List<SubjectDto> getAllSubjectAssociatedByCourseId(Long courseId) {
        List<SubjectEntity> subjectEntities = subjectRepository.findByCourseId(courseId);
        return subjectEntities.stream().map(subjectEntity -> convertToDTO(subjectEntity)).collect(Collectors.toList());
    }

//    public List<CourseDto> getAllStudentsAssociatedByCourseId(Long id) {
//        List<CourseEntity> courseEntities = studentRepository.findByid(id).getCourseEntities();
//        return courseEntities.stream().map(studentEntity -> convertCourseDTO(studentEntity)).collect(Collectors.toList());
//    }
    public List<StudentDto> getAllStudentsAssociatedByCourseId(Long courseId) {
//        Long Id = courseRepository.findByid(courseId).getId();
        List<StudentEntity> studentEntities = studentRepository.findByCourseId(courseId);
        return studentEntities.stream().map(studentEntity -> convertCourseDTO(studentEntity)).collect(Collectors.toList());
    }

    private StudentDto convertCourseDTO(StudentEntity studentEntity) {
        return StudentDto.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .courses(studentEntity.getCourse())
                .build();
    }

    private SubjectDto convertToDTO(SubjectEntity subjectEntity) {
        return SubjectDto.builder()
                .id(subjectEntity.getId())
                .name(subjectEntity.getName())
                .course(subjectEntity.getCourse())
                .build();
    }
}
