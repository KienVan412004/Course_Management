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
@Table(name = "classes")
public class Classes extends AuditEntity {
    @Id
    @Column(updatable = false,unique = true)
    private String id;

    private String className;

    private String classCode;

    private LocalDateTime startDate;

    @ManyToOne
    @JoinColumn(name = "teacher_id" ,referencedColumnName = "id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id" ,referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "course_id" , referencedColumnName = "id")
    private Course course;
}
