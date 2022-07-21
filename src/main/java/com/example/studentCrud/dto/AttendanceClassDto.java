package com.example.studentCrud.dto;

import com.example.studentCrud.entity.AttendanceClass;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
public class AttendanceClassDto {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String attendanceClassName;

    public static AttendanceClassDto response(AttendanceClass attendanceClass) {
        AttendanceClassDto dto = new AttendanceClassDto();
        dto.setId(dto.getId());
        dto.setAttendanceClassName(dto.getAttendanceClassName());
        return dto;
    }

    public AttendanceClass to() {
        AttendanceClass attendanceClass = new AttendanceClass();
        attendanceClass.setAttendanceClassName(this.attendanceClassName);
        return attendanceClass;
    }

    public AttendanceClass update(AttendanceClass attendanceClass) {
        attendanceClass.setAttendanceClassName(this.attendanceClassName);
        return attendanceClass;
    }

}

