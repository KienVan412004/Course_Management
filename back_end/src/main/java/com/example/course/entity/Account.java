package com.example.course.entity;

import com.example.course.common.AuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "account")
public class Account extends AuditEntity {

    @Id
    @Column(updatable = false, unique = true)
    private String id;

    private String email;

    private String password;

    private String fullName;

    private String phoneNumber;

    private Integer status;

    private Role role;

    private LocalDateTime dateOfBirth;

    private Integer gender;

    @Getter
    public enum Role{
        ADMIN,

        TEACHER,

        STUDENT
    }
}
