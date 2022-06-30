package com.example.studentCrud.dto;

import com.example.studentCrud.entity.Student;
import com.example.studentCrud.entity.StudentCourse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class StudentCourseListDTO {

    private List<StudentCourseDTO> studentCourses;

}
