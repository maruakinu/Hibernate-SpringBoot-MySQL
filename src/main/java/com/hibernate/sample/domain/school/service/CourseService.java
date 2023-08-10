package com.hibernate.sample.domain.school.service;

import com.hibernate.sample.domain.school.dto.SubjectDto;
import com.hibernate.sample.domain.school.entity.SubjectEntity;

import java.util.List;

public interface CourseService {

    List<SubjectDto> getSubjectByCourseId(final Long id);

}
