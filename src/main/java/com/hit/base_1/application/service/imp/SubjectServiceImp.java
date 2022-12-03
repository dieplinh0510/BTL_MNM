package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.dai.ScheduleDetailRepository;
import com.hit.base_1.application.dai.ScheduleRepository;
import com.hit.base_1.application.dai.StudentSubjectRepository;
import com.hit.base_1.application.dai.SubjectRepository;
import com.hit.base_1.application.output.GetTimeTableItemDetailOutput;
import com.hit.base_1.application.output.GetTimeTableItemOutput;
import com.hit.base_1.application.output.GetTimeTableOutput;
import com.hit.base_1.application.service.SubjectService;
import com.hit.base_1.application.utils.SecurityUtil;
import com.hit.base_1.domain.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {
  private final SubjectRepository subjectRepository;
  private final ScheduleRepository scheduleRepository;
  private final ScheduleDetailRepository scheduleDetailRepository;
  private final StudentSubjectRepository studentSubjectRepository;

  public SubjectServiceImp(SubjectRepository subjectRepository, ScheduleRepository scheduleRepository,
                           ScheduleDetailRepository scheduleDetailRepository,
                           StudentSubjectRepository studentSubjectRepository) {
    this.subjectRepository = subjectRepository;
    this.scheduleRepository = scheduleRepository;
    this.scheduleDetailRepository = scheduleDetailRepository;
    this.studentSubjectRepository = studentSubjectRepository;
  }

  @Override
  public List<Subject> getAllSubject() {
    return subjectRepository.findAll();
  }

  @Override
  public GetTimeTableOutput getTimeTable() {
    List<GetTimeTableItemOutput> items = new ArrayList<>();
    GetTimeTableItemOutput objItem;
    List<Subject> lstSubject = getAllSubject();

    for (Subject subject : lstSubject) {
      objItem = new GetTimeTableItemOutput();
      List<Schedule> lstSchedule = subject.getSchedules();
      List<GetTimeTableItemDetailOutput> itemDetails;

      for (Schedule schedule : lstSchedule) {
        GetTimeTableItemDetailOutput itemDetail;
        itemDetails = new ArrayList<>();

        List<ScheduleDetail> lstScheduleDetail = schedule.getScheduleDetails();
        for (ScheduleDetail scheduleDetail : lstScheduleDetail) {
          itemDetail = new GetTimeTableItemDetailOutput();
          objItem.setSubjectName(subject.getName());
          objItem.setRoom(schedule.getRoom());
          objItem.setAddress(schedule.getAddress());
          objItem.setLesson(scheduleDetail.getLesson());
          objItem.setTimeDetail(scheduleDetail.getTimeDetail());
          itemDetail.setTimeDetail(scheduleDetail.getTimeDetail());
          itemDetail.setWeek(scheduleDetail.getWeek());
          itemDetail.setFrom(scheduleDetail.getForm());
          itemDetails.add(itemDetail);
        }
        objItem.setTimeTableDetails(itemDetails);
      }
      items.add(objItem);
    }

    return new GetTimeTableOutput(items);
  }

  @Override
  public List<Subject> getAllSubjectByUserLogin() {
    String id = SecurityUtil.getCurrentUserLogin();
    try {
      Long.parseLong(id);
    } catch (Exception ex) {
      return null;
    }
    List<StudentSubject> studentSubjectList = studentSubjectRepository.findAllByStudent_Id(Long.parseLong(id));
    List<Subject> subjects = new ArrayList<>();
    for (StudentSubject s : studentSubjectList) {
      subjects.add(s.getSubject());
    }
    return subjects;
  }

  @Override
  public List<Student> getAllStudentBySubjectId(Long subjectId) {
    return null;
  }
}
