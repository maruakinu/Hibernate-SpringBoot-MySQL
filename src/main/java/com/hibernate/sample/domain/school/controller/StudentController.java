package com.hibernate.sample.domain.school.controller;

import com.hibernate.sample.domain.school.dto.StudentDto;
import com.hibernate.sample.domain.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/post")
    public StudentDto.SingleStudent<StudentDto> createStudent(@RequestBody StudentDto.SingleStudent<StudentDto> article) {
        return new StudentDto.SingleStudent<>(studentService.createStudent(article.getStudent()));
    }

    @GetMapping("/{id}")
    public StudentDto.SingleStudent<StudentDto> get_Student_And_Its_Associated_Courses(@PathVariable Long id) {
        return new StudentDto.SingleStudent<>(studentService.getStudent(id));
    }

}
