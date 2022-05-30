package com.example.studentCrud.service;

import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.enums.RecordStatus;

public interface AttendanceService {
    Attendance insertAttendance(AttendanceDto dto, RecordStatus recordStatus);
}
