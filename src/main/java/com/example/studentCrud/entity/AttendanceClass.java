package com.example.studentCrud.entity;

import com.example.studentCrud.enums.RecordStatus;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "ATTENDANCE_CLASS")
public class AttendanceClass extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATTENDANCE_CLASS_ID")
    private Long id;

    @Column(name = "ATTENDANCE_CLASS_Name")
    private String attendanceClassName;

}
