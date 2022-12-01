package com.hit.base_1.application.dai;

import com.hit.base_1.domain.entity.ScheduleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDetailRepository extends JpaRepository<ScheduleDetail, Long> {
}
