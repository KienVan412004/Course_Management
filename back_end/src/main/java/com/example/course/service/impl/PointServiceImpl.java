package com.example.course.service.impl;

import com.example.course.entity.*;
import com.example.course.model.request.AddPointRequest;
import com.example.course.model.response.GetPointByStudentIdResponse;
import com.example.course.model.response.GetPointStudentResponse;
import com.example.course.repository.*;
import com.example.course.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;

@Service
public class PointServiceImpl implements PointService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PointRepository pointRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Subject> getSubjectByCourse(String courseId) {
        return subjectRepository.getSubjectByCourseId(courseId);
    }

    @Override
    public List<Classes> getClassByCourse(String courseId) {
        return classesRepository.getClassByCourseId(courseId);
    }

    @Override
    public List<Student> getStudentByClassId(String classId) {
        return studentRepository.getStudentByIdClass(classId);
    }

    @Override
    public List<String> getIdStudentByIdClass(String classId) {
        return studentRepository.getIcStudentByIdClass(classId);
    }

    @Override
    public Point addPointStudent(AddPointRequest request) {
        Classes classes = classesRepository.findById(request.getClassId()).orElse(null);
        Subject subject = subjectRepository.findById(request.getSubjectId()).orElse(null);
        Point addPoint = new Point();
        List<String> studentIds = request.getStudentId();
        List<String> points = request.getPoint();

        List<Point> listIdPoint = pointRepository.existsByClassesAndSubject(request.getClassId(), request.getSubjectId());
        for (Point point: listIdPoint){
            pointRepository.deleteById(point.getId());
        }

        for (int i = 0; i < studentIds.size(); i++) {
            String idStudent = studentIds.get(i);
            String point = points.get(i);
            Student student = studentRepository.findById(idStudent).orElse(null);
            if (student != null) {
                if (point != null && !point.isEmpty()) {
                    addPoint.setPointStudent(Integer.valueOf(point));
                } else {
                    addPoint.setPointStudent(null);
                }
                addPoint.setId(genId());
                addPoint.setStudent(student);
                addPoint.setClasses(classes);
                addPoint.setSubject(subject);
                pointRepository.save(addPoint);
            }
        }

      return addPoint;
    }

    @Override
    public List<Point> getAllPoint() {
        return pointRepository.findAll();
    }

    @Override
    public List<Classes> getClassByTeacher(String teacherId) {
        return classesRepository.getClassByTeacherId(teacherId);
    }

    @Override
    public List<Subject> getSubjectByClassId(String classId) {

//        Long time = Calendar.getInstance().getTimeInMillis();
//        Instant instant = Instant.ofEpochMilli(time);
//        LocalDateTime currentDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//        List<Subject> getSubject= subjectRepository.getSubjectByClassId(classId);
//
//        for (Subject subject : getSubject) {
//
//            if (subject.getStartDate().toLocalDate().isEqual(currentDate.toLocalDate())
//                    || subject.getStartDate().toLocalDate().isBefore(currentDate.toLocalDate())) {
//                subject.setStatus(1);
//                subjectRepository.save(subject);
//            }
//            if ( subject.getEndDate().toLocalDate().isEqual(currentDate.toLocalDate()) ) {
//                subject.setStatus(2);
//                subjectRepository.save(subject);
//            }
//        }
//
//        return getSubject;
        return subjectRepository.getSubjectByClassId(classId);
    }

    @Override
    public List<GetPointStudentResponse> getPoinStudent(String classId, String subjectId) {
        return studentRepository.getPointStudent(classId,subjectId);
    }

    @Override
    public void changeStatus(String idSubject,String classId) {
        ;
        Optional<Subject> getOnSubject = subjectRepository.findById(idSubject);
        if (getOnSubject.isPresent()) {
            Subject subject = getOnSubject.get();
            if (subject.getStatus() == 1) {
                subject.setStatus(2);
                subjectRepository.save(subject);
            } else {
                subject.setStatus(1);
                subjectRepository.save(subject);
            }

        }
    }

    @Override
    public List<GetPointByStudentIdResponse> getPointStudentById(String id) {
        return pointRepository.getPointStudent(id);
    }


    public String genId() {
        String id = UUID.randomUUID().toString();
        return id;
    }
}
