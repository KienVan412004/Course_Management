package com.example.course.controller;

import com.example.course.entity.*;
import com.example.course.model.request.AddPointRequest;
import com.example.course.model.response.GetPointByStudentIdResponse;
import com.example.course.model.response.GetPointStudentResponse;
import com.example.course.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/point/")
public class PointController {
    @Autowired
    private PointService pointService;

    @PutMapping("change-status/{subjectId}/{classId}")
    public void changeStatus(@PathVariable  String subjectId ,@PathVariable String classId){
        pointService.changeStatus(subjectId,classId);
    }

    @GetMapping("get-all-course")
    public List<Course> getAllCourse(){
        return pointService.getAllCourse();
    }

    @GetMapping("get-subject-by-course/{id}")
    public List<Subject> getSubjectByCOurse(@PathVariable String id){
        return pointService.getSubjectByCourse(id);
    }

    @GetMapping("get-class-by-course/{id}")
    public List<Classes> getClassByCourse(@PathVariable String id){
        return pointService.getClassByCourse(id);
    }

    @GetMapping("get-student-by-class/{id}")
    public List<Student> getStudentByClass(@PathVariable String id){
        return pointService.getStudentByClassId(id);
    }

    @GetMapping("get-idStudent-by-idClass/{id}")
    public List<String> getIdStudentByIdClass(@PathVariable String id){
        return pointService.getIdStudentByIdClass(id);
    }

    @PostMapping("add-point-student")
    public Point addPointStudent(@RequestBody AddPointRequest request){
        return pointService.addPointStudent(request);
    }
    @GetMapping("get-all")
    public List<Point> getAll(){
        return pointService.getAllPoint();
    }
    @GetMapping("get-class-teacher/{id}")
    public List<Classes> getClassByStudent(@PathVariable  String id){
        return pointService.getClassByTeacher(id);
    }

    @GetMapping("get-subject-by-class/{id}")
    public List<Subject> getSubjectByClass(@PathVariable String id){
        return pointService.getSubjectByClassId(id);
    }

    @GetMapping("get-point-student/{classId}")
    public List<GetPointStudentResponse> getPointStudent(@PathVariable  String classId, String subjectId){
        return pointService.getPoinStudent(classId,subjectId);
    }

    @GetMapping("get-point-student-by-id/{id}")
    public List<GetPointByStudentIdResponse> getPointStudentById(@PathVariable  String id) {
        return pointService.getPointStudentById(id);

    }

}
