package com.upwork.interview.homework.repo;

import com.upwork.interview.homework.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
    @Query(value = "SELECT * FROM activity LEFT JOIN activity_classroom ac on activity.activity_id = ac.activity_id WHERE classroom_id = (SELECT class_room_id FROM classroom WHERE class_qr = :qr) AND NOW() < activity.start ORDER BY activity.start ASC", nativeQuery = true)
    List<Activity> getActivitiesByQr(@Param("qr") String qr);
}
