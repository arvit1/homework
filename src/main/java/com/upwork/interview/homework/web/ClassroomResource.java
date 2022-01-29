package com.upwork.interview.homework.web;

import com.upwork.interview.homework.model.Activity;
import com.upwork.interview.homework.repo.ClassroomRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/api")
public class ClassroomResource {
    private ClassroomRepo classroomRepo;

    public ClassroomResource(ClassroomRepo classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @GetMapping(path = "/activities")
    public Set<Activity> getClassrooms(@RequestParam String qr){
        return this.classroomRepo.findFirstByClassQr(qr).getActivities();
    }
}
