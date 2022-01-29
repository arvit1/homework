package com.upwork.interview.homework.repo;

import com.upwork.interview.homework.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
