package com.example.studentCrud.service.implementation;

import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.helper.AttendanceHelper;
import com.example.studentCrud.repository.AttendanceRepository;
import com.example.studentCrud.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository repository;
    private final AttendanceHelper helper;
    private final EntityManager em;

    @Override
    @Transactional
    public Attendance insertAttendance(AttendanceDto dto, RecordStatus recordStatus) {
        Attendance attendance = dto.to();
        helper.getSaveData(attendance, recordStatus);
        Attendance saveAttendance = repository.save(attendance);
        return saveAttendance;
    }
}
