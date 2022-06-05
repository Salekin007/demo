package com.example.studentCrud.repository;

import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findById(Integer id);

    Optional<Attendance> findByClassName(String className);

    @Query(value = "SELECT * FROM ATTENDANCE")
    Page<Attendance> findbyAttendance();
}