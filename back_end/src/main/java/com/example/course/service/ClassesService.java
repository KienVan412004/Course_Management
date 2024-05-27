package com.example.course.service;

import com.example.course.entity.Classes;
import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.entity.Teacher;
import com.example.course.model.request.AddClassRequest;
import com.example.course.model.request.AddClassToCourseRequest;
import com.example.course.model.request.AddStudentToClassRequest;
import com.example.course.model.request.SearchClassRequest;
import com.example.course.model.response.GetClassByTeacherResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClassesService {

    List<Classes> getAll();

    Page<Classes> getPageClass(SearchClassRequest request);

    List<Student> getAllStudent();

    List<Student> getStudentOutsideClass(String id);

    List<Course> getAllCourse();

    List<Teacher> getAllTeacher();


    List<Student> getStudentByIdCLass(String id);

    Classes getOne(String id);

    Classes addClassByIdSubject(AddClassRequest request);

    Classes addStudentToClass(AddStudentToClassRequest request);

    Classes addClassInCourse(AddClassToCourseRequest request);

    Boolean exportExcel();

    List<GetClassByTeacherResponse> getClassByTeacher(String teacherId);
}
