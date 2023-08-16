package com.hibernate.sample.domain.school.repository;

import com.hibernate.sample.domain.school.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity findByid(@Param("id") Long id);

    List<StudentEntity> findByCourseId(@Param("courseId") Long courseId);

}
