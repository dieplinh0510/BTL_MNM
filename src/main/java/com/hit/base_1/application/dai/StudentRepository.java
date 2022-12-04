package com.hit.base_1.application.dai;

import com.hit.base_1.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("select s from Student s where s.studentId = ?1")
  Student findByStudentId(String studentId);

}
