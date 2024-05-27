package com.example.course.service;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.entity.Subject;
import com.example.course.service.impl.RegisterCourseRequest;

import javax.mail.MessagingException;
import java.util.List;

public interface HomeService {

    List<Course> getAllCourse();

    Course detailCourse(String id);

    List<Subject> getSubjectByCourseId(String courseId);

    Student registerCourse(RegisterCourseRequest request) throws MessagingException;
}
