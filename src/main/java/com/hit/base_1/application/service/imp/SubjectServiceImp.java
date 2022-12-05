package com.hit.base_1.application.service.imp;

import com.hit.base_1.application.dai.*;
import com.hit.base_1.application.output.GetDetailStudentInfoOutput;
import com.hit.base_1.application.output.GetTimeTableItemDetailOutput;
import com.hit.base_1.application.output.GetTimeTableItemOutput;
import com.hit.base_1.application.output.GetTimeTableOutput;
import com.hit.base_1.application.service.SubjectService;
import com.hit.base_1.application.utils.SecurityUtil;
import com.hit.base_1.domain.dto.SubjectDto;
import com.hit.base_1.domain.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImp implements SubjectService {
  private final SubjectRepository subjectRepository;
  private final ScheduleRepository scheduleRepository;
  private final ScheduleDetailRepository scheduleDetailRepository;
  private final StudentSubjectRepository studentSubjectRepository;
  private final StudentRepository studentRepository;
  private final ManagerStudentHistoryRepository managerStudentHistoryRepository;

  public SubjectServiceImp(SubjectRepository subjectRepository, ScheduleRepository scheduleRepository,
                           ScheduleDetailRepository scheduleDetailRepository,
                           StudentSubjectRepository studentSubjectRepository, StudentRepository studentRepository,
                           ManagerStudentHistoryRepository managerStudentHistoryRepository) {
    this.subjectRepository = subjectRepository;
    this.scheduleRepository = scheduleRepository;
    this.scheduleDetailRepository = scheduleDetailRepository;
    this.studentSubjectRepository = studentSubjectRepository;
    this.studentRepository = studentRepository;
    this.managerStudentHistoryRepository = managerStudentHistoryRepository;
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
          objItem.setSubjectId(subject.getId());
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
    List<Student> output = new ArrayList<>();
    List<StudentSubject> studentSubjects = studentSubjectRepository.findAllBySubject_Id(subjectId);

    for (StudentSubject studentSubject : studentSubjects) {
      output.add(studentSubject.getStudent());
    }

    return output;
  }

  @Override
  public GetTimeTableItemOutput getTimeTableDetail(Long subjectId) {
    List<GetTimeTableItemOutput> items = new ArrayList<>();
    GetTimeTableItemOutput objItem;
    List<Subject> lstSubject = getAllSubject();

    for (Subject subject : lstSubject) {
      if (subject.getId().equals(subjectId)) {
        objItem = new GetTimeTableItemOutput();
        List<Schedule> lstSchedule = subject.getSchedules();
        List<GetTimeTableItemDetailOutput> itemDetails;

        for (Schedule schedule : lstSchedule) {
          GetTimeTableItemDetailOutput itemDetail;
          itemDetails = new ArrayList<>();

          List<ScheduleDetail> lstScheduleDetail = schedule.getScheduleDetails();
          for (ScheduleDetail scheduleDetail : lstScheduleDetail) {
            itemDetail = new GetTimeTableItemDetailOutput();
            objItem.setSubjectId(subject.getId());
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
    }

    return items.get(0);

  }

  // Logic đang fake
  @Override
  public GetDetailStudentInfoOutput getDetailInfoStudent(Long subjectId, String studentCode) {
    List<ManagerStudentHistory> managerStudentHistories =
        managerStudentHistoryRepository.findAllByStudentIdAndSubjectId(studentCode, subjectId);
    Student student = studentRepository.findByStudentId(studentCode);
    if (student == null) {
      return null;
    }
    Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
    if (optionalSubject.isEmpty()) {
      return null;
    }
    Subject subject = optionalSubject.get();
    GetDetailStudentInfoOutput output = new GetDetailStudentInfoOutput();
    output.setStudentName(student.getFullName());
    output.setStudentCode(student.getStudentId());
    output.setSubjectName(subject.getName());
    output.setGrade(String.valueOf(14));
    output.setNumberOfBreaks(getRandomNumber(0, 12));
    if (output.getNumberOfBreaks() < 5) {
      output.setCondition(true);
    } else {
      output.setCondition(false);
    }
    return output;
  }

  public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  @Override
  public Subject createNewSubject(SubjectDto dto) {
    return subjectRepository.save(new Subject(dto.getName(), dto.getNumberOfUnit(), dto.getStartTime(),
        dto.getEndTime(), dto.getPercents()));
  }

}
