package com.example.studentCrud.service.implementation;

import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.exception.ResourceNotFoundException;
import com.example.studentCrud.helper.AttendanceHelper;
import com.example.studentCrud.repository.AttendanceRepository;
import com.example.studentCrud.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Attendance> findById(Long id, RecordStatus recordStatus) {
        Optional<Attendance> attendance = repository.findById(id);
        return attendance;
    }

    @Override
    public List<Attendance> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Attendance> findbyAttendance() {
        return (List<Attendance>) repository.findbyAttendance();
    }


    @Override
    @Transactional
    public Attendance update(AttendanceDto dto, RecordStatus recordStatus) {
        Attendance attendance = repository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Attendance Id: " + dto.getId()));

        dto.update(attendance);
        helper.getUpdateData(attendance, recordStatus);

        Attendance updatedAttendance = repository.save(attendance);
        return updatedAttendance;
    }

//    @Override
//    public Optional<Attendance> findByName(String name) {
//        return Optional.empty();
//    }


    @Override
    public Optional<Attendance> findByClassName(String className) {
        return repository.findByClassName(className);
    }
}
