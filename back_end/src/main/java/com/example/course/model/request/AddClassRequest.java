package com.example.course.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddClassRequest {

    private String id;

    private String className;

    private String classCode;

    private String subjectId;

    private LocalDateTime createdDate;
}
