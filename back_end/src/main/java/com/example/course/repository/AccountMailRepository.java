package com.example.course.repository;

import com.example.course.entity.AccountMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMailRepository extends JpaRepository<AccountMail,String> {
    @Query(value = """
    select acm.id, acm.host,acm.port,acm.username,acm.password,acm.status 
    from account_mail acm where acm.status = 1
""",nativeQuery = true)
    AccountMail findByActiveTrue();
}
