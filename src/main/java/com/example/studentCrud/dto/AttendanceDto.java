package com.example.studentCrud.dto;

import com.example.studentCrud.entity.Attendance;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class AttendanceDto {

    private Long id;

    @NotNull
    private Long attendanceClassId;

    @NotNull
    private String sectionName;

    @NotNull
    private Date startTime;

    @NotNull
    private Date endTime;

    @NotNull
    private Long phoneNumber;

    @NotNull
    private String gender;

    private Long studentId;

    public static AttendanceDto response(Attendance attendance) {
        AttendanceDto dto = new AttendanceDto();
        dto.setId(attendance.getId());
        dto.setAttendanceClassId(attendance.getAttendanceClass().getId());
        dto.setSectionName(attendance.getSectionName());
        dto.setStartTime(attendance.getStartTime());
        dto.setEndTime(attendance.getEndTime());
        dto.setPhoneNumber(attendance.getPhoneNumber());
        dto.setGender(attendance.getGender());
        return dto;
    }

    public Attendance to() {
        Attendance attendance = new Attendance();
        attendance.setSectionName(this.sectionName);
        attendance.setStartTime(this.startTime);
        attendance.setEndTime(this.endTime);
        attendance.setPhoneNumber(this.phoneNumber);
        attendance.setGender(this.gender);
        return attendance;
    }

    public Attendance update(Attendance attendance) {
        attendance.setSectionName(this.sectionName);
        attendance.setStartTime(this.startTime);
        attendance.setEndTime(this.endTime);
        attendance.setPhoneNumber(this.phoneNumber);
        attendance.setGender(this.gender);
        return attendance;
    }

}

