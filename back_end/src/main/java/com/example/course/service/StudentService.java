package com.example.course.service;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.model.request.AddStudentRequest;
import com.example.course.model.response.StudentResponse;

import java.util.List;

public interface StudentService {

    List<Student> getALlStudent();

    List<StudentResponse> getStudent(String code);

    List<Course> getAllCourse();

    Student addStudent(AddStudentRequest request);

    Student getOneStudent(String id);

    Student updateStudent(AddStudentRequest request, String id);
}
