package com.example.course.repository;

import com.example.course.entity.Teacher;
import com.example.course.model.response.DetailTeacherResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {

    @Query(value = """
        select count(cl.teacher_id) as soLop, tc.full_name as fullName,tc.email,tc.phone_number as phoneNumber, tc.gender
         from teacher tc join classes cl on cl.teacher_id = tc.id  where tc.id = :id group by tc.id
""",nativeQuery = true)
    DetailTeacherResponse detailTeacher(String id);

}
