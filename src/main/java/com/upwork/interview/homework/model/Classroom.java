package com.upwork.interview.homework.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Classroom {
    @Id
    @GeneratedValue
    private long classRoomId;
    @Column(unique=true)
    private String classQr;

    public Classroom() { }
    public Classroom(long classRoomId) { this.classRoomId = classRoomId; }
}
