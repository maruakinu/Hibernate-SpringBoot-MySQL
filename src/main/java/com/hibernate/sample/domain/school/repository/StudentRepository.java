package com.hibernate.sample.domain.school.repository;

import com.hibernate.sample.domain.school.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, String> {}
