package com.example.course.repository;

import com.example.course.entity.Student;
import com.example.course.model.response.GetPointStudentResponse;
import com.example.course.model.response.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    @Query(value = """
                select st.course_id,  st.address, st.id, st.full_name, st.code, st.account_id, st.date_of_birth,st.phone_number, st.email, st.status from student st
                    join course_student cst on st.id = cst.student_id
                    where cst.course_id = :courseId
            """, nativeQuery = true)
    List<Student> getStudentByCourseId(String courseId);

    @Query(value = """
                select st.course_id,  st.created_date,st.updated_date, st.address, st.id, st.full_name, st.code, st.account_id,
                 st.date_of_birth,st.phone_number, st.email, st.status from student st
                    join class_student cst on st.id = cst.student_id 
                    where cst.class_id = :classId
            """, nativeQuery = true)
    List<Student> getStudentByIdClass(String classId);

    @Query(value = """
            select st.course_id, st.created_date,st.updated_date, st.address, st.id, st.full_name, st.code, st.account_id,
                  st.date_of_birth,st.phone_number, st.email, st.status from student st
                     join class_student cst on st.id = cst.student_id
                     where cst.class_id <> :classId
             """, nativeQuery = true)
    List<Student> getStudentOutsideClass(String classId);

    @Query(value = """
                select st.id from student st join class_student cst on cst.student_id = st.id 
                where cst.class_id = :classId
            """, nativeQuery = true)
    List<String> getIcStudentByIdClass(String classId);

    @Query(value = """
               SELECT COALESCE(p.point_student,"") AS pointStudent,
                      st.id as id,
                      st.full_name as fullName,
                      st.code as code
               FROM student st
               LEFT JOIN class_student cst ON st.id = cst.student_id
               LEFT JOIN point p ON p.student_id = st.id AND p.subject_id = :subjectId
               WHERE cst.class_id = :classId
            """,nativeQuery = true)

    List<GetPointStudentResponse> getPointStudent(String classId, String subjectId);


    @Query(value = """
            select st.course_id ,st.created_date,st.updated_date, st.address, st.id, st.full_name, st.code, st.account_id,
                  st.date_of_birth,st.phone_number, st.email, st.status from student st
                 order by st.created_date desc 
             """, nativeQuery = true)
    List<Student> getAllStudent();

    @Query(value = """
            select  st.full_name as fullName, st.code as code, st.id from student st
             where :code is null or st.code = :code
            """,nativeQuery = true)
    List<StudentResponse> getStudent(String code);


}
