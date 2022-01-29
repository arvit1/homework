package com.upwork.interview.homework.config;

import com.upwork.interview.homework.model.Classroom;
import com.upwork.interview.homework.model.Student;
import com.upwork.interview.homework.repo.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

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
            Student student1 = Student.builder()
                    .fullName("Patrick Pwayze").username("patrick").password("$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.").enabled(true).build();
            Student student2 = Student.builder()
                    .fullName("John Watson").username("john").password("$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea").enabled(true).build();
            Classroom classroom = Classroom.builder()
                    .classQr(UUID.randomUUID().toString()).build();
            classroom.attend(student1);
            classroom.attend(student2);
            Classroom classroom2 = Classroom.builder()
                    .classQr(UUID.randomUUID().toString()).build();
            classroom2.attend(student1);
            classroom2.attend(student2);
            classrooms.add(classroom);
            classrooms.add(classroom2);
            classroomRepo.saveAll(classrooms);
        }
    }
}
