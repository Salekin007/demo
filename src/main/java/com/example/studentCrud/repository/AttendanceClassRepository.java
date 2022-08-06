package com.example.studentCrud.repository;

import com.example.studentCrud.entity.AttendanceClass;
import com.example.studentCrud.enums.RecordStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceClassRepository extends JpaRepository<AttendanceClass, Long> {

    Optional<AttendanceClass> findById(Integer id);

    List<AttendanceClass> findByRecordStatusNot(RecordStatus recordStatus);

    Optional<AttendanceClass> findByAttendanceClassName(String attendanceClassName);

    Optional<AttendanceClass> findByIdAndRecordStatusNot(Long id, RecordStatus recordStatus);

    @Query(value = "SELECT * FROM ATTENDANCE_CLASS where STUDENT_ID = :studentId", nativeQuery = true)
    List<AttendanceClass> findByStudentId(Long studentId);
}
