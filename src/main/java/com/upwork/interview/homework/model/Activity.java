package com.upwork.interview.homework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @Builder @AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;
    @Column(unique=true)
    private String name;
    @Column(unique=true)
    private LocalDateTime start;
    private LocalDateTime end;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_activity", joinColumns = { @JoinColumn(name = "activity_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private Set<Student> students;

    public Activity() { }
    public Activity(Long activityId) { this.activityId = activityId; }

    public void attend(Student student){
        if (this.students == null)
            this.students = new HashSet<>(0);

        this.students.add(student);

    }
}
