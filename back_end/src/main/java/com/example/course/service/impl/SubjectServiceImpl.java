package com.example.course.service.impl;

import com.example.course.entity.Classes;
import com.example.course.entity.Course;
import com.example.course.entity.Subject;
import com.example.course.model.request.AddSubjectRequest;
import com.example.course.model.response.GetStatusSubjectByIdResponse;
import com.example.course.repository.ClassesRepository;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.SubjectRepository;
import com.example.course.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Subject getOne(String id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Classes> getClassBySubjectId(String id) {
        return classesRepository.getClassBySubjectId(id);
    }

    @Override
    public Subject addSubjectByCourse(AddSubjectRequest request) {
        long time = Calendar.getInstance().getTimeInMillis();
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        Course course = courseRepository.findById(request.getCourseId()).orElse(null);
        Subject subject = new Subject();
        subject.setId(getID());
        subject.setSubjectCode(genMa());
        subject.setResult(request.getResult());
        subject.setSubjectName(request.getSubjectName());
        subject.setDescription(request.getDescription());
        subject.setCourse(course);
        subject.setCreatedDate(localDateTime);
        subject.setStatus(0);
        subject.setStartDate(request.getStartDate());
        subject.setEndDate(request.getEndDate());
        subjectRepository.save(subject);

        return subject;
    }

    @Override
    public GetStatusSubjectByIdResponse getStatus(String subjectId) {
        return  subjectRepository.getStatus(subjectId);
    }

//    @Scheduled(cron = "0 * * * * ?")
//    @Transactional
//    public void cronJobCheckSubject() {
//        boolean flag = true;
//        long time = Calendar.getInstance().getTimeInMillis();
//        Instant instant = Instant.ofEpochMilli(time);
//        LocalDateTime dateNow = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//        List<Subject> subjectList = subjectRepository.GetAllSubjectWrong(dateNow);
//        for (Subject subject : subjectList) {
//            if (subject.getStartDate().isAfter(dateNow) && subject.getStatus() != 0) {
//                subject.setStatus(0);
//                flag= true;
//            } else if (subject.getEndDate().isBefore(dateNow) && subject.getStatus()!= 2) {
//                subject.setStatus(2);
//                flag = true;
//            } else if (subject.getStartDate().isAfter(dateNow) || subject.getStartDate().isEqual(dateNow) &&
//                       subject.getEndDate().isAfter(dateNow) && subject.getStatus()!= 1) {
//                subject.setStatus(1);
//                flag = true;
//            }
//        }
//        if(flag){
//            subjectRepository.saveAll(subjectList);
//        }
//    }

    public String getID() {
        String id = UUID.randomUUID().toString();
        return id;
    }



    public String genMa() {
        String font = "MH";
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Số ngẫu nhiên từ 100000 đến 999999
        String ma = font + randomNumber;
        return ma;
    }


}
