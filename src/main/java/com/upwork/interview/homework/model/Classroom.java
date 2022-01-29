package com.upwork.interview.homework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @Builder @AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classRoomId;
    @Column(unique=true)
    private String classQr;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_classroom", joinColumns = { @JoinColumn(name = "classroom_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private Set<Student> students;

    public Classroom() { }
    public Classroom(long classRoomId) { this.classRoomId = classRoomId; }

    public void attend(Student student){
        if (this.students == null)
            this.students = new HashSet<>(0);

        this.students.add(student);

    }
}
