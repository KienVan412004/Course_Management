package com.example.course.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddPointRequest {
    private List<PointAddRequest> pointAdd;

    private List<String> studentId;

    private List<String> point;

    private String subjectId;

    private String classId;
}
