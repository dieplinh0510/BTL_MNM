package com.hit.base_1.application.dai;

import com.hit.base_1.domain.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {

  @Query("select s from StudentSubject s where s.student.id = ?1")
  List<StudentSubject> findAllByStudent_Id(Long id);

}
