package com.example.course.controller;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.model.request.AddStudentRequest;
import com.example.course.model.response.StudentResponse;
import com.example.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("get-all")
    public List<Student> getAllStudent(){
        return studentService.getALlStudent();
    }
    @GetMapping("get-student")
    public List<StudentResponse> getAllStudent(String code){
        return studentService.getStudent(code);
    }
    @GetMapping("get-all-course")
    public List<Course> getAllCourse(){
        return studentService.getAllCourse();
    }

    @PostMapping("add-student")
    public Student addStudent(@RequestBody AddStudentRequest request){
        return studentService.addStudent(request);
    }

    @GetMapping("get-one/{id}")
    public Student getOne(@PathVariable String id){
        return studentService.getOneStudent(id);
    }

    @PutMapping("update-student/{id}")
    public Student updateStudent(@RequestBody AddStudentRequest request,@PathVariable String id){
        return studentService.updateStudent(request,id);
    }


}
