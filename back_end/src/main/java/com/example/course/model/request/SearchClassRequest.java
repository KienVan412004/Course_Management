package com.example.course.model.request;

import com.example.course.common.PageableRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchClassRequest extends PageableRequest {

    private String ma;
}
