package com.example.course.repository;

import com.example.course.entity.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SendMailRepository extends JpaRepository<SendMail,String> {
    @Query(value = """
    select sm.id,sm.title,sm.content,sm.type from send_mail sm where sm.type = :name
""",nativeQuery = true)
    SendMail findTemplateByName(String name);

}
