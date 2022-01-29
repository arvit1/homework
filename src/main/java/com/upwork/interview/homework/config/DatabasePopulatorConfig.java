package com.upwork.interview.homework.config;

import com.upwork.interview.homework.model.Classroom;
import com.upwork.interview.homework.repo.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.init.DatabasePopulator;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Configuration
public class DatabasePopulatorConfig {

    @Autowired
    private ClassroomRepo classroomRepo;

    @PostConstruct
    public void init(){
        List<Classroom> classrooms = classroomRepo.findAll();
        if (classrooms.isEmpty()){
            Classroom classroom = Classroom.builder()
                    .classQr(UUID.randomUUID().toString()).build();
            Classroom classroom2 = Classroom.builder()
                    .classQr(UUID.randomUUID().toString()).build();
            classrooms.add(classroom);
            classrooms.add(classroom2);
            classroomRepo.saveAll(classrooms);
        }
    }
}
