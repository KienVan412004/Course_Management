package com.example.course.service;

import com.example.course.entity.Classes;
import com.example.course.entity.Subject;
import com.example.course.model.request.AddSubjectRequest;
import com.example.course.model.response.GetStatusSubjectByIdResponse;

import java.util.List;

public interface SubjectService {

    Subject getOne(String id);

    List<Classes> getClassBySubjectId(String id);

    Subject addSubjectByCourse(AddSubjectRequest request);

    GetStatusSubjectByIdResponse getStatus(String subjectId);


}
