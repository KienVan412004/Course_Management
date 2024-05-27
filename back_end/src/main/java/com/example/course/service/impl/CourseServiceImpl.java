package com.example.course.service.impl;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.entity.Subject;
import com.example.course.model.request.AddCourseRequest;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.ClassStudentRepository;
import com.example.course.repository.StudentRepository;
import com.example.course.repository.SubjectRepository;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassStudentRepository courseStudentRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.getAllCourse();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByCourseId(String courseId) {

        return studentRepository.getStudentByCourseId(courseId);
    }

    @Override
    public List<Subject> getSubjectByCourseId(String courseId) {
        return subjectRepository.getSubjectByCourseId(courseId);
    }

    @Override
    public Course addCourse(AddCourseRequest addCourseRequest) {

        long timestamp = Calendar.getInstance().getTimeInMillis();
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        Course course1 = new Course();
        course1.setDescription(addCourseRequest.getDescription());
        course1.setName(addCourseRequest.getName());
        course1.setEndDate(addCourseRequest.getEndDate());
        course1.setStartDate(addCourseRequest.getStartDate());
        course1.setTotalStudent(addCourseRequest.getTotalStudent());
        course1.setStatus(1);
        course1.setId(genID());
        course1.setCreatedDate(localDateTime);
        course1.setImage(addCourseRequest.getImage());
        course1.setPrice(addCourseRequest.getPrice());
        course1.setEstimatedStartTime(addCourseRequest.getEstimatedStartTime());
        courseRepository.save(course1);
        for(String nameSubject: addCourseRequest.getSubjectName()){
            Subject subject = new Subject();
            subject.setSubjectName(nameSubject);
            subject.setCourse(course1);
            subject.setId(genID());
            subject.setSubjectCode(genMa());
            subjectRepository.save(subject);
        }


//        List<ClassStudent> addList = new ArrayList<>();
//        for (String id : addCourseRequest.getStudentId()) {
//            Student courseStudent = studentRepository.findById(id).get();
//            ClassStudent courseStudentAdd = new ClassStudent();
//            courseStudentAdd.setStudent(courseStudent);
////            courseStudentAdd.setCourse(course1);
//            courseStudentAdd.setId(genID());
//           addList.add(courseStudentAdd);
//        }

//        courseStudentRepository.saveAll(addList);



        return course1;
    }

    @Override
    public Course updateCourse(Course course, String id) {
        return null;
    }

    @Override
    public Course getOne(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public String genID() {
        String id = UUID.randomUUID().toString();
        return id;
    }

    int count = 1;
    public String genMa(){
        String font = "KH";
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Số ngẫu nhiên từ 100000 đến 999999
        String ma = font + randomNumber;
        return ma;
    }
}
