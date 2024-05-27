package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.entity.Subject;
import com.example.course.model.request.AddCourseRequest;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/course/")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("get-all")
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("get-all-student")
    public List<Student> getAllStudent(){
        return courseService.getAllStudent();
    }

    @PostMapping("add-course")
    public Course addCourse(@RequestBody  AddCourseRequest addCourseRequest){
        return courseService.addCourse(addCourseRequest);
    }

    @GetMapping("get-student-by-course/{id}")
    public List<Student> getStudentByCourse(@PathVariable String id){
        return courseService.getStudentByCourseId(id);
    }

    @GetMapping("get-subject-by-course/{id}")
    public List<Subject> getSubjectByCourse(@PathVariable String id){
        return courseService.getSubjectByCourseId(id);
    }

    @GetMapping("get-one/{id}")
    public Course getOne(@PathVariable String id){
        return courseService.getOne(id);
    }

}
