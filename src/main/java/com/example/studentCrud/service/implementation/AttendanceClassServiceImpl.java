package com.example.studentCrud.service.implementation;

import com.example.studentCrud.dto.AttendanceClassDto;
import com.example.studentCrud.entity.AttendanceClass;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.exception.ResourceNotFoundException;
import com.example.studentCrud.repository.AttendanceClassRepository;
import com.example.studentCrud.service.AttendanceClassService;
import com.example.studentCrud.helper.AttendanceClassHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceClassServiceImpl implements AttendanceClassService {

    private final AttendanceClassRepository repository;
    private final AttendanceClassHelper helper;

    @Override
    public AttendanceClass insertAttendance(AttendanceClassDto dto, RecordStatus recordStatus) {
        AttendanceClass attendanceClass = dto.to();
        helper.getSaveData(attendanceClass, recordStatus);
        attendanceClass = repository.save(attendanceClass);
        return attendanceClass;
    }

    @Override
    public Optional<AttendanceClass> findById(Long id, RecordStatus draft) {
        Optional<AttendanceClass> attendanceClass = repository.findById(id);
        return attendanceClass;
    }

    @Override
    public List<AttendanceClass> findAll() {

        return repository.findAll();
    }

    @Override
    public Optional<AttendanceClass> findByClassName(String className) {
        return Optional.empty();
    }

    @Override
    public void updateRecordStatus(Long id, RecordStatus status) {
        AttendanceClass attendanceClass = repository.findByIdAndRecordStatusNot(id, status)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance Class Id: " + id));
        helper.getUpdateData(attendanceClass, status);

        repository.save(attendanceClass);

    }

    @Override
    public AttendanceClass update(AttendanceClassDto dto, RecordStatus draft) {
        AttendanceClass attendanceClass = repository.findByIdAndRecordStatusNot(dto.getId(), draft)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance Class Id: " + dto.getId()));
        helper.getUpdateData(attendanceClass, draft);
        dto.update(attendanceClass);
        repository.save(attendanceClass);
        return attendanceClass;
    }
}
