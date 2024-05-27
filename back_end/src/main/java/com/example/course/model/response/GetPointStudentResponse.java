package com.example.course.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.Target;

public interface GetPointStudentResponse {

    String getId();

    String getCode();


    String getFullName();


    String getPointStudent();
}
