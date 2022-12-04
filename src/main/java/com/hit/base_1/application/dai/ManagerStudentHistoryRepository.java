package com.hit.base_1.application.dai;

import com.hit.base_1.domain.entity.ManagerStudentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerStudentHistoryRepository extends JpaRepository<ManagerStudentHistory, Long> {

  @Query("select m from ManagerStudentHistory m where m.studentId = ?1 and m.subjectId = ?2")
  List<ManagerStudentHistory> findAllByStudentIdAndSubjectId(String studentId, Long subjectId);

}
