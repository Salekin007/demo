package com.example.studentCrud.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "ATTENDANCE")
public class Attendance extends BaseEntity {
    @Id

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATTENDANCE_ID")
    private Long id;

    @Column(name = "ATTENDANCE_NAME")
    private String name;

    @Column(name = "ATTENDANCE_DURATION")
    private String duration;
}
