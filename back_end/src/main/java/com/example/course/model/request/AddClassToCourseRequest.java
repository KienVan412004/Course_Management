package com.example.course.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddClassToCourseRequest {
    private String className;

    private LocalDateTime startDate;

    private String courseId;

    private String teacherId;
}
