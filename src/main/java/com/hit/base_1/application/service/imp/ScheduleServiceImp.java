package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.dai.DateRepository;
import com.hit.base_1.application.dai.ScheduleDetailRepository;
import com.hit.base_1.application.dai.ScheduleRepository;
import com.hit.base_1.application.dai.SubjectRepository;
import com.hit.base_1.application.service.ScheduleService;
import com.hit.base_1.config.exception.VsException;
import com.hit.base_1.domain.dto.ScheduleDetailDto;
import com.hit.base_1.domain.dto.ScheduleDto;
import com.hit.base_1.domain.entity.Date;
import com.hit.base_1.domain.entity.Schedule;
import com.hit.base_1.domain.entity.ScheduleDetail;
import com.hit.base_1.domain.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleServiceImp implements ScheduleService {
  private final ScheduleRepository scheduleRepository;
  private final ScheduleDetailRepository scheduleDetailRepository;
  private final SubjectRepository subjectRepository;
  private final DateRepository dateRepository;

  public ScheduleServiceImp(ScheduleRepository scheduleRepository, ScheduleDetailRepository scheduleDetailRepository,
                            SubjectRepository subjectRepository, DateRepository dateRepository) {
    this.scheduleRepository = scheduleRepository;
    this.scheduleDetailRepository = scheduleDetailRepository;
    this.subjectRepository = subjectRepository;
    this.dateRepository = dateRepository;
  }

  @Override
  public Schedule createSchedule(ScheduleDto scheduleDto) {
    Optional<Subject> optionalSubject = subjectRepository.findById(scheduleDto.getSubjectId());
    if (optionalSubject.isEmpty()) {
      throw new VsException("", "Không tồn tại subjectId " + scheduleDto.getSubjectId());
    }
    Subject subject = optionalSubject.get();

    Optional<Date> optionalDate = dateRepository.findById(scheduleDto.getDateId());
    if (optionalDate.isEmpty()) {
      throw new VsException("", "Không tồn tại dateId " + scheduleDto.getDateId());
    }
    Date date = optionalDate.get();

    Schedule schedule = scheduleRepository.save(new Schedule(subject, date, scheduleDto.getAddress(),
        scheduleDto.getRoom()));

    for (ScheduleDetailDto scheduleDetailDto : scheduleDto.getScheduleDetailDtos()) {
      scheduleDetailRepository.save(new ScheduleDetail(schedule, scheduleDetailDto.getLesson(),
          scheduleDetailDto.getForm(), scheduleDetailDto.getTimeDetail(), scheduleDetailDto.getWeek(), null));
    }

    return schedule;
  }
}
