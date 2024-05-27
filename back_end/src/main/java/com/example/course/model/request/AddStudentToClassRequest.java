package com.example.course.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddStudentToClassRequest {
    private String id;

    private String classId;

    private List<String> studentId;
}
