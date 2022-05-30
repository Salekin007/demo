package com.example.studentCrud.dto;

import com.example.studentCrud.entity.Attendance;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
public class AttendanceDto {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String duration;

    public static AttendanceDto response(Attendance attendance) {
        AttendanceDto dto = new AttendanceDto();
        dto.setId(attendance.getId());
        dto.setName(attendance.getName());
        dto.setDuration(attendance.getDuration());
        return dto;
    }

    public Attendance to() {
        Attendance attendance = new Attendance();
        attendance.setName(this.name);
        attendance.setDuration(this.duration);
        return attendance;
    }

    public Attendance update(Attendance attendance) {
        attendance.setName(this.name);
        attendance.setDuration(this.duration);
        return attendance;
    }

}

