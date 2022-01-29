package com.upwork.interview.homework.web;

import com.upwork.interview.homework.model.Classroom;
import com.upwork.interview.homework.repo.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/classrooms")
public class ClassroomResource {
    private ClassroomRepo classroomRepo;

    public ClassroomResource(ClassroomRepo classroomRepo) {
        this.classroomRepo = classroomRepo;
    }

    @GetMapping
    public List<Classroom> getClassrooms(){
        return this.classroomRepo.findAll();
    }
}