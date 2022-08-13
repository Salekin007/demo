package com.example.studentCrud.response;

import com.example.studentCrud.entity.Attendance;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AttendanceResponse {

    private Long id;

    private Long studentId;

    private Date attendanceDate;

    public static AttendanceResponse response(Attendance attendance){
        AttendanceResponse response = new AttendanceResponse();
        response.setId(attendance.getId());
        response.setStudentId(attendance.getStudent().getId());
        response.setAttendanceDate(attendance.getAttendanceDate());
        return response;
    }
}
