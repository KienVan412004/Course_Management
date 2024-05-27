package com.example.course.repository;

import com.example.course.entity.Classes;
import com.example.course.model.request.SearchClassRequest;
import com.example.course.model.response.GetClassByTeacherResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, String> {

    @Query(value = """
    select cl.course_id,cl.start_date, cl.id,cl.class_name,cl.class_code,cl.subject_id,cl.teacher_id,
    cl.created_date,cl.updated_date from classes cl where cl.subject_id = :id
     order by cl.created_date desc
""",nativeQuery = true)
    List<Classes>  getClassBySubjectId(String id);

    @Query(value = """
select t.full_name,c.name, cl.id, cl.class_name,cl.class_code,cl.subject_id, cl.course_id, cl.teacher_id,cl.start_date, 
cl.created_date, cl.updated_date from classes cl join course c on cl.course_id = c.id join teacher t 
on cl.teacher_id = t.id
""", nativeQuery = true)
    List<Classes> getAllClass();

    @Query(value = """
select t.full_name,c.name, cl.id, cl.class_name,cl.class_code,cl.subject_id, cl.course_id, cl.teacher_id,cl.start_date, 
cl.created_date, cl.updated_date from classes cl join course c on cl.course_id = c.id join teacher t 
on cl.teacher_id = t.id  where (:#{#req.ma} is null or cl.class_code = :#{#req.ma})
""", nativeQuery = true)
    Page<Classes> getPageClass(@Param("req") SearchClassRequest req, Pageable pageable);

    @Query(value = """
    select cl.course_id,cl.start_date, cl.id,cl.class_name,cl.class_code,cl.subject_id,cl.teacher_id,
    cl.created_date,cl.updated_date from classes cl where cl.course_id = :id
     order by cl.created_date desc
""",nativeQuery = true)
    List<Classes>  getClassByCourseId(String id);

    @Query(value = """
    select cl.course_id,cl.start_date, cl.id,cl.class_name,cl.class_code,cl.subject_id,cl.teacher_id,
    cl.created_date,cl.updated_date from classes cl where cl.teacher_id = :id
     order by cl.created_date desc
""",nativeQuery = true)
    List<Classes>  getClassByTeacherId(String id);

    @Query(value = """
    select cl.id, cl.class_name as className, cl.class_code as classCode, cl.teacher_id as teacherId from classes cl 
    where cl.teacher_id = :teacherId
    """,nativeQuery = true)
    List<GetClassByTeacherResponse> getClassByTeacher(String teacherId);

}
