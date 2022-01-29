package com.upwork.interview.homework.repo;

import com.upwork.interview.homework.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
