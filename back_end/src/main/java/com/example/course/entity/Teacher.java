package com.example.course.entity;

import com.example.course.common.AuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "teacher")
public class Teacher extends AuditEntity {

    @Id
    @Column(updatable = false,unique = true)
    private String id;

    @Nationalized
    private String fullName;

    private String email;

    private Integer phoneNumber;

    private Integer gender;

    private Integer status;

    private String subject;
}
