package com.example.studentCrud.service;

import com.example.studentCrud.dto.StudentCourseListDTO;
import com.example.studentCrud.dto.StudentDto;
import com.example.studentCrud.entity.Student;
import com.example.studentCrud.entity.StudentCourse;
import com.example.studentCrud.enums.RecordStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentService {
    Map<String, Object> getList(String name, Integer page, Integer size);

    List<Student> findAll();

    Optional<Student> findById(Long id, RecordStatus recordStatus);

    Optional<Student> findById(Long id);

    Student saveEncloser(Student student);

    Optional<Student> findByName(String name);

    Student insertCourse(StudentDto dto, RecordStatus recordStatus);

    Student update(StudentDto dto, RecordStatus recordStatus);

    Student studentCourse(StudentCourseListDTO dto, Student student);
}
