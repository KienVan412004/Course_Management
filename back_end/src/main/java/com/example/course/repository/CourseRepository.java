package com.example.course.repository;

import com.example.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query(value = """
            select kh.image_home, kh.image,kh.estimated_start_time,kh.price, kh.id, kh.name,kh.description,kh.start_date,kh.end_date,kh.status,
            kh.total_student,kh.created_date,kh.updated_date 
            from course kh order by kh.created_date desc 
            """,nativeQuery = true)
    List<Course> getAllCourse();
}
