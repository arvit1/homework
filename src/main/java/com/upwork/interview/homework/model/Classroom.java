package com.upwork.interview.homework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data @Builder @AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classRoomId;
    @Column(unique=true)
    private String classQr;

    public Classroom() { }
    public Classroom(long classRoomId) { this.classRoomId = classRoomId; }
}
