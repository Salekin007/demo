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
    @JoinColumn(name="STUDENT_ID")
    private Student student;

    @Column(name = "ATTENDANCE_Date")
    private Date attendanceDate;

}
