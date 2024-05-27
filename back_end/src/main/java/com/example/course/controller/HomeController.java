package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.entity.Subject;
import com.example.course.service.HomeService;
import com.example.course.service.impl.RegisterCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/api/home/")
@CrossOrigin("*")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("get-all-course")
    public List<Course> getAllCourse(){
        return homeService.getAllCourse();
    }

    @GetMapping("detail-course-home/{id}")
    public Course detailCourse(@PathVariable String id){
        return homeService.detailCourse(id);
    }

    @PostMapping("register-course")
    public Student registerCourse(@RequestBody RegisterCourseRequest request) throws MessagingException {
        return homeService.registerCourse(request);
    }

    @GetMapping("get-subject-by-course/{id}")
    public List<Subject> getSubjectByCourse(@PathVariable String id){
        return homeService.getSubjectByCourseId(id);
    }



}
