package com.example.course.Security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountLogin {
    private String userName;
    private String password;

}
