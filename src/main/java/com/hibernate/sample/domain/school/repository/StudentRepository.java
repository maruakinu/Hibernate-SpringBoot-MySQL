package com.hibernate.sample.domain.school.repository;

import com.hibernate.sample.domain.school.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

 //   @Query("SELECT s FROM StudentEntity s LEFT JOIN CourseEntity c ON s.courseEntity.id  = c.id ")
    StudentEntity findByid(@Param("id") Long id);

}
