package com.example.studentCrud.service;

import com.example.studentCrud.dto.AttendanceClassDto;
import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.entity.AttendanceClass;
import com.example.studentCrud.enums.RecordStatus;

import java.util.List;
import java.util.Optional;

public interface AttendanceClassService {

    AttendanceClass insertAttendance(AttendanceClassDto dto, RecordStatus recordStatus);
    Optional<AttendanceClass> findById(Long id, RecordStatus draft);
    List<AttendanceClass> findAll();
    Optional<AttendanceClass> findByClassName(String className);
    void updateRecordStatus(Long id, RecordStatus status);

    AttendanceClass update(AttendanceClassDto dto, RecordStatus draft);
}
