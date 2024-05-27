package com.example.course.controller;

import com.example.course.entity.Classes;
import com.example.course.entity.Subject;
import com.example.course.model.request.AddSubjectRequest;
import com.example.course.model.response.GetStatusSubjectByIdResponse;
import com.example.course.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/subject/")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("get-one/{id}")
    public Subject getOne(@PathVariable String id){
        return subjectService.getOne(id);
    }

    @GetMapping("get-class-by-subject-id/{id}")
    public List<Classes> getClassBySubjectId(@PathVariable String id){
        return subjectService.getClassBySubjectId(id);
    }

    @PostMapping("add-subject-by-course")
    public Subject addSubjectByCourse(@RequestBody  AddSubjectRequest request){
        return subjectService.addSubjectByCourse(request);
    }

    @GetMapping("get-subject-by-id/{id}")
    public GetStatusSubjectByIdResponse getSubjectByID(@PathVariable String id){
        return subjectService.getStatus(id);
    }

}
