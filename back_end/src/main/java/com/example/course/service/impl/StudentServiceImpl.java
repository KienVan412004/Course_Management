package com.example.course.service.impl;

import com.example.course.entity.Course;
import com.example.course.entity.Student;
import com.example.course.model.request.AddStudentRequest;
import com.example.course.model.response.StudentResponse;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.StudentRepository;
import com.example.course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Student> getALlStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public List<StudentResponse> getStudent(String code) {
        return studentRepository.getStudent(code);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Student addStudent(AddStudentRequest request) {
        Course getCourse = courseRepository.findById(request.getCourseId()).orElse(null);

        Student student = new Student();
        student.setId(genId());
        student.setCode(genCode());
        student.setAddress(request.getAddress());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setEmail(request.getEmail());
        student.setFullName(request.getFullName());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setCourse(getCourse);
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student getOneStudent(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(AddStudentRequest request, String id) {
        Optional<Student> getOne = studentRepository.findById(id);
        Course getCourse = courseRepository.findById(request.getCourseId()).orElse(null);
        if(getOne.isPresent()) {
            Student student = getOne.get();
            student.setAddress(request.getAddress());
            student.setDateOfBirth(request.getDateOfBirth());
            student.setEmail(request.getEmail());
            student.setFullName(request.getFullName());
            student.setPhoneNumber(request.getPhoneNumber());
            student.setCourse(getCourse);
            studentRepository.save(student);
            return student;
        }else {
            return null;
        }

    }

    public String genId(){
        String id = UUID.randomUUID().toString();
        return id;
    }

    int count = 1;
    public String genCode(){
        String font = "SV";
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Số ngẫu nhiên từ 100000 đến 999999
        String ma = font + randomNumber;
        return ma;
    }
}
