package com.example.course.service.impl;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RegisterCourseRequest {

    private String id;

    private String code;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String email;

    private LocalDateTime createdDate;

    private String courseId;

    private LocalDateTime dateOfBirth;
}
