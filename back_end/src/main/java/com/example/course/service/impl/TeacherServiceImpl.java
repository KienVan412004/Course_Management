package com.example.course.service.impl;

import com.example.course.entity.Teacher;
import com.example.course.model.response.DetailTeacherResponse;
import com.example.course.repository.TeacherRepository;
import com.example.course.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public DetailTeacherResponse detailTeacher(String id) {
        return teacherRepository.detailTeacher(id);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        Long time = Calendar.getInstance().getTimeInMillis();
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        Teacher teacher1 = new Teacher();
        teacher1.setId(genId());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setGender(teacher.getGender());
        teacher1.setPhoneNumber(teacher.getPhoneNumber());
        teacher1.setFullName(teacher.getFullName());
        teacher1.setCreatedDate(localDateTime);
        teacher1.setStatus(1);
        teacherRepository.save(teacher1);
        return teacher1;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, String id) {
        Optional<Teacher> getOne = teacherRepository.findById(id);
        if(getOne.isPresent()){
            Teacher teacher1 = getOne.get();
            teacher1.setEmail(teacher.getEmail());
            teacher1.setGender(teacher.getGender());
            teacher1.setPhoneNumber(teacher.getPhoneNumber());
            teacher1.setFullName(teacher.getFullName());
            teacher1.setStatus(1);
            teacherRepository.save(teacher1);
            return teacher1;
        }else{
            return null;
        }


    }

    public String genId(){
        String id = UUID.randomUUID().toString();
        return id;
    }
}
