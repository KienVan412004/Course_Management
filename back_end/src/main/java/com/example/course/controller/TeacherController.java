package com.example.course.controller;

import com.example.course.entity.Teacher;
import com.example.course.model.response.DetailTeacherResponse;
import com.example.course.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/")
@CrossOrigin("*")
public class TeacherController {
   @Autowired
   private TeacherService teacherService;

   @GetMapping("get-all")
    public List<Teacher> getAll(){
       return teacherService.getAll();
   }
    @GetMapping("get-one/{id}")
    public DetailTeacherResponse getAll(@PathVariable String id){
        return teacherService.detailTeacher(id);
    }

   @PostMapping("add-teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
       return teacherService.addTeacher(teacher);
   }

   @PutMapping("update-teacher/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher,@PathVariable String id){
       return teacherService.updateTeacher(teacher,id);
   }

}
