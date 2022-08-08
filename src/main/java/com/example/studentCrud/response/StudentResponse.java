package com.example.studentCrud.response;

import com.example.studentCrud.entity.Student;
import com.example.studentCrud.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponse {

    private Long id;

    private String name;

    private Gender gender;

    private Long classNameId;

    public static StudentResponse response(Student student){
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setGender(student.getGender());
        response.setClassNameId(student.getClassName().getId());
        return response;
    }
}
