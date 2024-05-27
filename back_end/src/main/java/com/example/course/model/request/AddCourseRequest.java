package com.example.course.model.request;

import com.example.course.entity.Subject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class AddCourseRequest {

    private String name;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer totalStudent;

    private List<String> studentId;

    private List<String> subjectName;

    private String image;

    private Double price;

    private String estimatedStartTime;


}
