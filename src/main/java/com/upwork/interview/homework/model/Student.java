package com.upwork.interview.homework.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private long studentId;
    private String studentName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
    private Set<Classroom> courses = new HashSet<>(0);

    public Student() { }
    public Student(long studentId) { this.studentId = studentId; }
}
