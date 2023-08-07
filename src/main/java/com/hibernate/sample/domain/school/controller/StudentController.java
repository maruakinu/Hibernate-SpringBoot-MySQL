package com.hibernate.sample.domain.school.controller;

import com.hibernate.sample.domain.school.dto.StudentDto;
import com.hibernate.sample.domain.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/post")
    public StudentDto.SingleStudent<StudentDto> createArticle(@RequestBody StudentDto.SingleStudent<StudentDto> article) {
        return new StudentDto.SingleStudent<>(studentService.createStudent(article.getStudent()));
    }

}
