package com.example.studentCrud.dto;

import com.example.studentCrud.entity.ClassName;
import com.example.studentCrud.entity.Course;
import com.example.studentCrud.entity.Student;
import com.example.studentCrud.enums.Gender;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class StudentDto {


    private Long id;

    private String name;

    private Gender gender;

    private Long classNameId;


    public static StudentDto response(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setGender(student.getGender());
        dto.setClassNameId(student.getClassName().getId());
        return dto;
    }

    public Student to() {
        Student student = new Student();
        student.setName(this.name);
        student.setGender(this.gender);
        return student;
    }

}
