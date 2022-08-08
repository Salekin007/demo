package com.example.studentCrud.dto;

import com.example.studentCrud.entity.Attendance;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class AttendanceDto {

    private Long id;

    @NotNull
    private Long studentId;

    @NotNull
    private Date attendanceDate;


    public static AttendanceDto response(Attendance attendance) {
        AttendanceDto dto = new AttendanceDto();
        dto.setId(attendance.getId());
        dto.setStudentId(attendance.getStudent().getId());
        dto.setAttendanceDate(attendance.getAttendanceDate());
        return dto;
    }

    public Attendance to() {
        Attendance attendance = new Attendance();
        attendance.setAttendanceDate(this.attendanceDate);
        return attendance;
    }

    public Attendance update(Attendance attendance) {
        attendance.setAttendanceDate(this.attendanceDate);
        return attendance;
    }

}

