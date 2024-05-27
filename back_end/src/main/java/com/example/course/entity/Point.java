package com.example.course.entity;

import com.example.course.common.AuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "point")
public class Point  {

    @Id
    @Column(updatable = false, unique = true)
    private String id;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Classes Classes;

    @ManyToOne
    @JoinColumn(name = "student_id" , referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    private Integer pointStudent;

    private String pointType;
}
