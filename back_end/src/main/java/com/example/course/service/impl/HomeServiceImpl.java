package com.example.course.service.impl;

import com.example.course.common.ConfigMail;
import com.example.course.entity.Course;
import com.example.course.entity.SendMail;
import com.example.course.entity.Student;
import com.example.course.entity.Subject;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.SendMailRepository;
import com.example.course.repository.StudentRepository;
import com.example.course.repository.SubjectRepository;
import com.example.course.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private ConfigMail configMail;
    @Autowired
    private JavaMailSender mailSender;
    @Value("NewwaveSolution")
    private String fromMail;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SendMailRepository sendMailRepository;
    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Course detailCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Subject> getSubjectByCourseId(String courseId) {
        return subjectRepository.getSubjectByCourseId(courseId);
    }

    @Override
    public Student registerCourse(RegisterCourseRequest request) throws MessagingException {
        Course course = courseRepository.findById(request.getCourseId()).orElse(null);
        Student student = new Student();
        student.setId(genId());
        student.setCode(genMa());
        student.setEmail(request.getEmail().trim());
        student.setAddress(request.getAddress());
        student.setFullName(request.getFullName());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setCourse(course);
        student.setStatus(0);
        studentRepository.save(student);
        SendMail sendMail = sendMailRepository.findTemplateByName("Mail đăng kí");
        String emailContent = sendMail.getContent();
        String title = sendMail.getTitle();

        emailContent = emailContent.replace("name",request.getFullName());
        emailContent = emailContent.replace("code", genMa());
        assert course != null;
        emailContent = emailContent.replace("Course",course.getName());
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true,"UTF-8");
        helper.setText(emailContent,true);
        helper.setFrom(fromMail);
        helper.setSubject(title);
        helper.setTo(request.getEmail().trim());
        mailSender.send(mimeMailMessage);

        return student;
    }

    public String genId(){
        String id = UUID.randomUUID().toString();
        return id;
    }

    int count = 1;
    public String genMa(){
        String font = "SV";
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Số ngẫu nhiên từ 100000 đến 999999
        String ma = font + randomNumber;
        return ma;
    }
}
