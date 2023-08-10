package com.hibernate.sample.domain.school.repository;

import com.hibernate.sample.domain.school.dto.SubjectDto;
import com.hibernate.sample.domain.school.entity.SubjectEntity;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

//    SubjectEntity findByid(@Param("id") Long id);
//@Query("SELECT c FROM CourseEntity c LEFT JOIN Subject s ON s.course_id = c.id ")
 //   @Query(value = "SELECT c FROM SubjectEntity c WHERE c.course_id = :courseId")
 //   @Query(value = "SELECT u FROM SubjectEntity u WHERE u.course_id = :courseId", nativeQuery = true)
//    List<SubjectEntity> findByCourseId(@Param("courseId") Long courseId);

    List<SubjectEntity> findByCourseId(@Param("courseId") Long courseId);



}
