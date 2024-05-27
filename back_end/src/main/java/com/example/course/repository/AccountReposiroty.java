package com.example.course.repository;

import com.example.course.entity.Account;
import com.example.course.model.request.GetAccountRequest;
import com.example.course.model.response.GetAccountResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountReposiroty extends JpaRepository<Account, String> {
    @Query(value = """
    select ac.created_date,ac.updated_date, ac.id, ac.full_name, ac.email,ac.password,ac.phone_number, ac.date_of_birth,ac.status,ac.role,
     ac.gender from account  ac
    where  (:#{#request.fullName} IS NULL OR ac.full_name like %:#{#request.fullName}%)
""", nativeQuery = true)
    Page<Account> getAccount(@Param("request") GetAccountRequest request, Pageable pageable);

    Account findByEmail(String email);

}
