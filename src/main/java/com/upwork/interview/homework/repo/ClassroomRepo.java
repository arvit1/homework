package com.upwork.interview.homework.repo;

import com.upwork.interview.homework.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepo extends JpaRepository<Classroom, Long> {
    Classroom findFirstByClassQr(String classQr);
}
