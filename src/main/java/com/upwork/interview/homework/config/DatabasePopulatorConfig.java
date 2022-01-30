package com.upwork.interview.homework.config;

import com.upwork.interview.homework.model.Activity;
import com.upwork.interview.homework.model.Classroom;
import com.upwork.interview.homework.model.Student;
import com.upwork.interview.homework.repo.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
            Student student3 = Student.builder()
                    .fullName("Admin Me").username("admin").password("$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.").enabled(true).build();
            Classroom classroom = Classroom.builder()
                    .classQr("56f36af2-b860-442c-a812-74ef03760487").build();
            Activity activity1 = Activity.builder().name("Math").start(LocalDateTime.parse("2022-02-04T10:00:00"))
                    .end(LocalDateTime.parse("2022-02-04T10:50:00")).build();
            Activity activity2 = Activity.builder().name("Physics").start(LocalDateTime.parse("2022-02-04T11:00:00"))
                    .end(LocalDateTime.parse("2022-02-04T11:50:00")).build();
            Activity activity3 = Activity.builder().name("Chemistry").start(LocalDateTime.parse("2022-02-04T12:00:00"))
                    .end(LocalDateTime.parse("2022-02-04T12:50:00")).build();
            activity1.attend(student1);
            activity2.attend(student2);
            activity3.attend(student3);
            classroom.addActivity(activity1);
            classroom.addActivity(activity3);
            Classroom classroom2 = Classroom.builder()
                    .classQr(UUID.randomUUID().toString()).build();
            classroom2.addActivity(activity2);
            classroom2.addActivity(activity3);

            classrooms.add(classroom);
            classrooms.add(classroom2);
            classroomRepo.saveAll(classrooms);
        }
    }
}
