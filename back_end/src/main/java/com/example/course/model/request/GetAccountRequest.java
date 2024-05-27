package com.example.course.model.request;

import com.example.course.common.PageableRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetAccountRequest extends PageableRequest {

    private String fullName;

    private Date startDate;

    private Date endDate;
}
