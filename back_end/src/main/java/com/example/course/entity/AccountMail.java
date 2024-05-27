package com.example.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_mail")
public class AccountMail {
    @Id
    @Column(updatable = false,unique = true)
    private String id;

    private String host;

    private Integer port;

    private String username;

    private String password;

    private Integer status;
}
