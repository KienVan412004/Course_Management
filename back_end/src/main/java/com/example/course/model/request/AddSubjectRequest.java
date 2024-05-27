package com.example.course.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddSubjectRequest {

    private String id;

    private String description;

    private String subjectName;

    private String subjectCode;

    private String courseId;

    private String result;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
