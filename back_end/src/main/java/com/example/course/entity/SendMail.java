package com.example.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "send_mail")
public class SendMail {
    @Id
    @Column(updatable = false,unique = true)
    private String id;

    private String title;

    private String content;

    private String type;
}
