package com.upwork.interview.homework.web;

import com.upwork.interview.homework.model.Activity;
import com.upwork.interview.homework.model.Student;
import com.upwork.interview.homework.repo.ActivityRepo;
import com.upwork.interview.homework.repo.ClassroomRepo;
import com.upwork.interview.homework.repo.StudentRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ClassroomResource {
    private ClassroomRepo classroomRepo;
    private StudentRepo studentRepo;
    private ActivityRepo activityRepo;

    public ClassroomResource(ClassroomRepo classroomRepo, StudentRepo studentRepo, ActivityRepo activityRepo) {
        this.classroomRepo = classroomRepo;
        this.studentRepo = studentRepo;
        this.activityRepo = activityRepo;
    }

    @GetMapping(path = "/activities")
    public List<Activity> getActivities(@RequestParam String qr){
        return activityRepo.getActivitiesByQr(qr);
    }

    @GetMapping(path = "/checkin")
    public Activity checkin(@RequestParam Long activityId, Principal principal){
        Student student = studentRepo.getUserByUsername(principal.getName());
        Activity activity = activityRepo.findById(activityId).orElseThrow();
        activity.attend(student);
        activityRepo.save(activity);
        return activity;
    }
}
