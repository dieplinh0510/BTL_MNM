package com.hit.base_1.application.dai;

import com.hit.base_1.domain.entity.ManagerStudentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerStudentHistoryRepository extends JpaRepository<ManagerStudentHistory, Long> {
}
