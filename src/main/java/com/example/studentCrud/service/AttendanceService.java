package com.example.studentCrud.service;

import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.dto.CourseDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.entity.Course;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.exception.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    Attendance insertAttendance(AttendanceDto dto, RecordStatus recordStatus);

    Optional<Attendance> findById(Long id, RecordStatus draft);
    List<Attendance> findAll();

    List<Attendance> findbyAttendance(int page, int size);

    List<Attendance> findByStudentId(Long studentId);
    Attendance update(AttendanceDto dto, RecordStatus recordStatus);

    void updateRecordStatus(Long id, RecordStatus status);

}
