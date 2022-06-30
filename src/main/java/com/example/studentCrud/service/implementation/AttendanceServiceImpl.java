package com.example.studentCrud.service.implementation;

import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.exception.ResourceNotFoundException;
import com.example.studentCrud.helper.AttendanceHelper;
import com.example.studentCrud.repository.AttendanceRepository;
import com.example.studentCrud.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Attendance> findByStudentId(Long studentId) {
        return repository.findByStudentId(studentId);
    }
    @Override
    public Optional<Attendance> findById(Long id, RecordStatus recordStatus) {
        Optional<Attendance> attendance = repository.findById(id);
        return attendance;
    }

    @Override
    public List<Attendance> findAll() {
//        return repository.findByRecordStatusNot(RecordStatus.DELETED);
        return repository.findAll();
    }


    @Override
    public List<Attendance> findbyAttendance(int page, int size) {
        return repository.findbyAttendance(getPageable(page, size)).getContent();
    }

    @Override
    @Transactional
    public void updateRecordStatus(Long id, RecordStatus status) {
        Attendance attendance = repository.findByIdAndRecordStatusNot(id, status)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Id: " + id));
        helper.getUpdateData(attendance, status);

        repository.save(attendance);
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
    Optional<Attendance> findByIdAndRecordStatusNot(Long id, RecordStatus status) {
        return repository.findByIdAndRecordStatusNot(id, status);
    }


    @Override
    public Optional<Attendance> findByClassName(String className) {
        return repository.findByClassName(className);
    }


    private Pageable getPageable(int page, int size) {
        return new Pageable() {
            @Override
            public int getPageNumber() {
                return page;
            }

            @Override
            public int getPageSize() {
                return size;
            }

            @Override
            public long getOffset() {
                return (page - 1) * size;
            }

            @Override
            public Sort getSort() {
                return Sort.by(Sort.Order.by("id"));
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public Pageable withPage(int pageNumber) {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
    }
}
