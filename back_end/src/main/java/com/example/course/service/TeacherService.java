package com.example.course.service;

import com.example.course.entity.Teacher;
import com.example.course.model.response.DetailTeacherResponse;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAll();

    DetailTeacherResponse detailTeacher(String id);

    Teacher addTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher, String id);
}
