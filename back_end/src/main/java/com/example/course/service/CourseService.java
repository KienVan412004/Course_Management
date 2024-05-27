package com.example.course.service;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.entity.Subject;
import com.example.course.model.request.AddCourseRequest;

import java.util.List;

public interface CourseService {

    List<Course> getAll();

    List<Student> getAllStudent();

    List<Student> getStudentByCourseId(String courseId);

    List<Subject> getSubjectByCourseId(String courseId);

    Course addCourse(AddCourseRequest addCourseRequest);

    Course updateCourse(Course course, String id);

    Course getOne(String id);
}
