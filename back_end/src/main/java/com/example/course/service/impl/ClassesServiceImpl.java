package com.example.course.service.impl;

import com.example.course.entity.*;
import com.example.course.model.request.AddClassRequest;
import com.example.course.model.request.AddClassToCourseRequest;
import com.example.course.model.request.AddStudentToClassRequest;
import com.example.course.model.request.SearchClassRequest;
import com.example.course.model.response.GetClassByTeacherResponse;
import com.example.course.repository.*;
import com.example.course.service.ClassesService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ClassStudentRepository classStudentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Classes> getAll() {
        return classesRepository.getAllClass();
    }

    @Override
    public Page<Classes> getPageClass(SearchClassRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(),request.getSize());
        return classesRepository.getPageClass(request,pageable);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentOutsideClass(String id) {
        return studentRepository.getStudentOutsideClass(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Student> getStudentByIdCLass(String id) {
        return studentRepository.getStudentByIdClass(id);
    }

    @Override
    public Classes getOne(String id) {
        return classesRepository.findById(id).orElse(null);
    }

    @Override
    public Classes addClassByIdSubject(AddClassRequest request) {
        long time = Calendar.getInstance().getTimeInMillis();
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        Subject subject = subjectRepository.findById(request.getSubjectId()).orElse(null);
        Classes classes1 = new Classes();
        classes1.setClassName(request.getClassName());
        classes1.setClassCode(genMa());
        classes1.setId(genID());
        classes1.setSubject(subject);
        classes1.setCreatedDate(localDateTime);
        classesRepository.save(classes1);
        return classes1;
    }

    @Override
    public Classes addStudentToClass(AddStudentToClassRequest request) {
        List<ClassStudent> classStudents = new ArrayList<>();
        Classes classes = classesRepository.findById(request.getClassId()).orElse(null);
        for (String id : request.getStudentId()) {
            Student student = studentRepository.findById(id).get();

            ClassStudent classStudent = new ClassStudent();
            classStudent.setStudent(student);
            classStudent.setId(genID());
            classStudent.setAClass(classes);
            classStudents.add(classStudent);
        }
        classStudentRepository.saveAll(classStudents);


        return classes;
    }

    @Override
    public Classes addClassInCourse(AddClassToCourseRequest request) {
        long time = Calendar.getInstance().getTimeInMillis();
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        Course course = courseRepository.findById(request.getCourseId()).orElse(null);
        Teacher teacher = teacherRepository.findById(request.getTeacherId()).orElse(null);

        Classes classes = new Classes();
        classes.setId(genID());
        classes.setCourse(course);
        classes.setClassName(request.getClassName());
        classes.setClassCode(genMa());
        classes.setTeacher(teacher);
        classes.setStartDate(request.getStartDate());
        classes.setCreatedDate(localDateTime);
        classesRepository.save(classes);
        return classes;
    }

    @Override
    public Boolean exportExcel() {
        String userHome = System.getProperty("user.home");
        String outPutPath = userHome + File.separator + "Downloads" + File.separator + "file_template_import" + ".xlsx";

        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet =workbook.createSheet("Import sinh viên");

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row header = sheet.createRow(0);
        Cell cell =header.createCell(0);
        cell.setCellValue("STT");

        Cell cell1 = header.createCell(1);
        cell1.setCellValue("Mã sinh viên");

        Cell cell2 = header.createCell(2);
        cell2.setCellValue("Mã lớp");
        try {
            FileOutputStream outputStream = new FileOutputStream(outPutPath);
            workbook.write(outputStream);
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<GetClassByTeacherResponse> getClassByTeacher(String teacherId) {
        return classesRepository.getClassByTeacher(teacherId);
    }

    public String genID() {
        String id = UUID.randomUUID().toString();
        return id;
    }

    int count = 1;

    public String genMa() {
        String font = "LH";
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Số ngẫu nhiên từ 100000 đến 999999
        String ma = font + randomNumber;
        return ma;
    }
}
