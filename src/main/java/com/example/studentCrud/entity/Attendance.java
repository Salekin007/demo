package com.example.studentCrud.entity;

import com.example.studentCrud.enums.Gender;
import com.example.studentCrud.enums.RecordStatus;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "ATTENDANCE_CLASS_ID")
    private AttendanceClass attendanceClass;

    @Column(name = "ATTENDANCE_SECTION")
    private String sectionName;

    @Column(name = "ATTENDANCE_Start_Time")
    private Date startTime;

    @Column(name = "ATTENDANCE_End_Time")
    private Date endTime;

    @Column(name = "ATTENDANCE_Phone_Number")
    private Long phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ATTENDANCE_gender")
    private Gender gender;

}
