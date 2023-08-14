package com.hibernate.sample.domain.school.repository;

import com.hibernate.sample.domain.school.entity.CourseEntity;
import com.hibernate.sample.domain.school.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    SubjectEntity findByid(@Param("id") Long id);
}
