package com.example.course.controller;

import com.example.course.entity.Classes;
import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.entity.Teacher;
import com.example.course.model.request.AddClassRequest;
import com.example.course.model.request.AddClassToCourseRequest;
import com.example.course.model.request.AddStudentToClassRequest;
import com.example.course.model.request.SearchClassRequest;
import com.example.course.model.response.GetClassByTeacherResponse;
import com.example.course.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes/")
@CrossOrigin("*")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("get-all")
    public List<Classes> getAll(){
        return classesService.getAll();
    }

    @GetMapping("get-page")
    public Page<Classes> getPage(SearchClassRequest request){
        return classesService.getPageClass(request);
    }
    @GetMapping("get-all-student")
    public List<Student> getAllStudent(){
        return classesService.getAllStudent();
    }

    @GetMapping("get-one/{id}")
    public Classes getOne(@PathVariable  String id){
        return classesService.getOne(id);
    }
    @GetMapping("get-class-by-teacher/{id}")
    public List<GetClassByTeacherResponse> getClassByTeacher(@PathVariable  String id){
        return classesService.getClassByTeacher(id);
    }

    @GetMapping("get-student-by-class/{id}")
    public List<Student> getStudentByClass(@PathVariable  String id){
        return classesService.getStudentByIdCLass(id);
    }

    @PostMapping("add-class-by-subject")
    public Classes addClass(@RequestBody AddClassRequest request){
        return classesService.addClassByIdSubject(request);
    }

    @PostMapping("add-student-to-class")
    public Classes addClass(@RequestBody AddStudentToClassRequest request){
        return classesService.addStudentToClass(request);
    }
    @GetMapping("get-all-course")
    public List<Course> getAllCourse(){
        return classesService.getAllCourse();
    }

    @GetMapping("get-all-teacher")
    public List<Teacher> getAllTeacher(){
        return classesService.getAllTeacher();
    }
    @PostMapping("add-class-to-course")
    public Classes addClassToCourse(@RequestBody  AddClassToCourseRequest request){
        return classesService.addClassInCourse(request);
    }

    @GetMapping("get-student-outside-class/{id}")
    public List<Student> getStudentOutsideClass(@PathVariable String id){
        return classesService.getStudentOutsideClass(id);
    }

    @PostMapping("export-excel")
    public Boolean exportExcel(){
        return classesService.exportExcel();
    }
}
