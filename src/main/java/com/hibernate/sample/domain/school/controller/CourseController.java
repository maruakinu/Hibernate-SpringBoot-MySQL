package com.hibernate.sample.domain.school.controller;

import com.hibernate.sample.domain.school.dto.CourseDto;
import com.hibernate.sample.domain.school.dto.StudentDto;
import com.hibernate.sample.domain.school.dto.SubjectDto;
import com.hibernate.sample.domain.school.entity.SubjectEntity;
import com.hibernate.sample.domain.school.repository.SubjectRepository;
import com.hibernate.sample.domain.school.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectRepository subjectRepository;


    @GetMapping("/{courseId}/subjects")
    public SubjectDto.MultipleSubjects get_All_Subjects_Associated_By_CourseId(@PathVariable Long courseId) {
        return SubjectDto.MultipleSubjects.builder()
                .subjects(courseService.getAllSubjectAssociatedByCourseId(courseId))
                .build();
    }

    @GetMapping("/{courseId}/students")
    public StudentDto.MultipleStudents get_All_Students_Associated_By_CourseId(@PathVariable Long courseId) {
        return StudentDto.MultipleStudents.builder()
                .students(courseService.getAllStudentsAssociatedByCourseId(courseId))
                .build();
    }

      // Another Implementation of Get with OneToMany using List
//    @GetMapping("/{courseId}/subjects")
//    public List<SubjectDto> getSubjectsByCourseId(@PathVariable Long courseId) {
//       return courseService.getSubjectByCourseId(courseId);
//    }


      // Another Implementation of Get with OneToMany using List but this is direct call to repository
//    @GetMapping("/{courseId}/comments")
//    public List<SubjectEntity> getAllCommentsByPostId(@PathVariable (value = "courseId") Long courseId) {
//        return subjectRepository.findByCourseId(courseId);
//    }


}
