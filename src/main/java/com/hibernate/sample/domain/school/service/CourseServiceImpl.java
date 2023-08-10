package com.hibernate.sample.domain.school.service;

import com.hibernate.sample.domain.school.dto.SubjectDto;
import com.hibernate.sample.domain.school.entity.CourseEntity;
import com.hibernate.sample.domain.school.entity.SubjectEntity;
import com.hibernate.sample.domain.school.repository.CourseRepository;
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


//    @Override
//    public List<SubjectDto> getSubjectByCourseId(Long id) {
//        Long courseId = courseRepository.findByid(id).getId();
//        List<SubjectEntity> subjectEntities = subjectRepository.findByCourseId(courseId);
//        return subjectEntities.stream().map(subjectEntity -> convertToDTO(subjectEntity)).collect(Collectors.toList());
//    }

    @Override
    public List<SubjectDto> getSubjectByCourseId(Long courseId) {

       // return subjectRepository.findByCourseId(courseId);
        List<SubjectEntity> subjectEntities = subjectRepository.findByCourseId(courseId);

        return subjectEntities.stream().map(subjectEntity -> convertToDTO(subjectEntity)).collect(Collectors.toList());

//        Long courseIds = courseRepository.findByid(courseId).getId();
//        List<SubjectEntity> subjectEntities = subjectRepository.findByCourseId(courseIds);
//        return subjectEntities.stream().map(subjectEntity -> convertToDTO(subjectEntity)).collect(Collectors.toList());
    }

    private SubjectDto convertToDTO(SubjectEntity subjectEntity) {
        return SubjectDto.builder()
                .id(subjectEntity.getId())
                .name(subjectEntity.getName())
                .course(subjectEntity.getCourse())
                .build();
    }
}
