package com.upwork.interview.homework.repo;

import com.upwork.interview.homework.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("SELECT u FROM Student u WHERE u.username = :username")
    Student getUserByUsername(@Param("username") String username);
}
