package com.example.course.entity;

import com.example.course.common.AuditEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "subject")
public class Subject extends AuditEntity {
    @Id
    @Column(unique = true,updatable = false)
    private String id;

    private String subjectName;

    private String subjectCode;

    private String description;

    private String result;

    private Integer status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;


    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

}
