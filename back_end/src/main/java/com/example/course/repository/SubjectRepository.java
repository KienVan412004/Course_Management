package com.example.course.repository;

import com.example.course.entity.Subject;
import com.example.course.model.response.GetStatusSubjectByIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

    @Query(value = """
            select sb.start_date,sb.end_date,  sb.status, sb.result, sb.id , sb.subject_name,sb.description, sb.subject_code , sb.course_id,
                 sb.created_date,sb.updated_date from subject sb where sb.subject_code = :code
            """, nativeQuery = true)
    Boolean existsByCode(String code);

    @Query(value = """
                select sb.start_date,sb.end_date,  sb.status, sb.result, sb.id , sb.subject_name,sb.description, sb.subject_code , sb.course_id,
                 sb.created_date,sb.updated_date from subject sb where sb.course_id = :courseId
            """, nativeQuery = true)
    List<Subject> getSubjectByCourseId(String courseId);

    @Query(value = """
               select sb.start_date,sb.end_date,  sb.status, sb.subject_name,sb.subject_code,sb.result,sb.description,sb.id,sb.created_date,sb.updated_date,sb.course_id
                from subject sb join course c on c.id = sb.course_id join classes cl on cl.course_id = c.id
               where cl.id = :classId order by sb.created_date 
            """, nativeQuery = true)
    List<Subject> getSubjectByClassId(String classId);

    @Query(value = """
                select sb.start_date,sb.end_date,  sb.status, sb.subject_name,sb.subject_code,sb.result,sb.description,sb.id,sb.created_date,sb.updated_date,sb.course_id from subject sb 
                where (sb.start_date > :dateNow and sb.status !=0)
                or(sb.end_date <= :dateNow and sb.status != 2)
                or ((sb.start_date <= :dateNow and sb.end_date > :dateNow) and sb.status != 1)
            """, nativeQuery = true)
    List<Subject> GetAllSubjectWrong(LocalDateTime dateNow);

    @Query(value = """
                    select sb.status as status from subject sb where sb.id = :subjectId
            """, nativeQuery = true)
    GetStatusSubjectByIdResponse getStatus(String subjectId);


}
