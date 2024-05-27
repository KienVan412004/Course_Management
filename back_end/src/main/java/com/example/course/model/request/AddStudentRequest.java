package com.example.course.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddStudentRequest {
    private String id;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String email;

    private LocalDateTime dateOfBirth;

    private String courseId;
}
