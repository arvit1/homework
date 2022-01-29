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
    @JoinTable(name = "activity_classroom", joinColumns = { @JoinColumn(name = "classroom_id") }, inverseJoinColumns = { @JoinColumn(name = "activity_id") })
    private Set<Activity> activities;

    public Classroom() { }
    public Classroom(Long classRoomId) { this.classRoomId = classRoomId; }

    public void addActivity(Activity activity){
        if (this.activities == null)
            this.activities = new HashSet<>(0);

        this.activities.add(activity);

    }
}
