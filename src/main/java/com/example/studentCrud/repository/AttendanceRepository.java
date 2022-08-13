package com.example.studentCrud.repository;

import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.enums.RecordStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findById(Integer id);

    List<Attendance> findByRecordStatusNot(RecordStatus recordStatus);

    @Query(value = "SELECT a FROM Attendance a")
    Page<Attendance> findbyAttendance(Pageable pageable);

    Optional<Attendance> findByIdAndRecordStatusNot(Long id, RecordStatus recordStatus);

    @Query(value = "SELECT * FROM ATTENDANCE where STUDENT_ID = :studentId", nativeQuery = true)
    List<Attendance> findByStudentId(Long studentId);

    @Query(value = "SELECT * FROM ATTENDANCE where ATTENDANCE_Date LIKE %:date%", nativeQuery = true)
    List<Attendance> findByAttendanceDate(String date);
}
