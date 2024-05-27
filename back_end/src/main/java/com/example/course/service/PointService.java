package com.example.course.service;

import com.example.course.entity.*;
import com.example.course.model.request.AddPointRequest;
import com.example.course.model.response.GetPointByStudentIdResponse;
import com.example.course.model.response.GetPointStudentResponse;

import java.util.List;

public interface PointService {

    List<Course> getAllCourse();

    List<Subject> getSubjectByCourse(String courseId);

    List<Classes> getClassByCourse(String courseId);

    List<Student> getStudentByClassId(String classId);

    List<String> getIdStudentByIdClass(String classId);

    Point addPointStudent(AddPointRequest request);

    List<Point> getAllPoint();

    List<Classes> getClassByTeacher(String teacherId);

    List<Subject> getSubjectByClassId(String classId);

    List<GetPointStudentResponse> getPoinStudent(String classId, String subjectId);

    void changeStatus(String idSubject, String classId);

    List<GetPointByStudentIdResponse> getPointStudentById(String id);


}
