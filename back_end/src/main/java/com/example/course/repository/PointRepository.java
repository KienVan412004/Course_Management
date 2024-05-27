package com.example.course.repository;

import com.example.course.entity.Classes;
import com.example.course.entity.Point;
import com.example.course.entity.Subject;
import com.example.course.model.response.GetPointByStudentIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, String> {


    @Query(value = """
                select p.id,p.class_id,p.student_id,p.point_student,p.point_type,p.subject_id from point p 
                where p.class_id = :classesId and p.subject_id = :subjectId
            """, nativeQuery = true)
    List<Point> existsByClassesAndSubject(String classesId, String subjectId);

    @Query(value = """
            SELECT c.name as nameCourse , sb.subject_name as subjectName, sb.status, COALESCE(p.point_student, NULL)
             AS pointStudent, sb.subject_code as subjectCode
            FROM subject sb
            LEFT JOIN point p ON p.subject_id = sb.id AND p.student_id = :id
            LEFT JOIN student st ON st.id = p.student_id
            left join course c on c.id = st.course_id
            WHERE sb.course_id = (
                SELECT course_id
                FROM student
                WHERE id = :id
            ) order by sb.created_date
            """, nativeQuery = true)

    List<GetPointByStudentIdResponse> getPointStudent(String id);
}
