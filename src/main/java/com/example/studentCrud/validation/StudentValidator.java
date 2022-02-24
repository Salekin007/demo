package com.example.studentCrud.validation;

import com.example.studentCrud.dto.CourseDto;
import com.example.studentCrud.dto.StudentDto;
import com.example.studentCrud.entity.Course;
import com.example.studentCrud.entity.Student;
import com.example.studentCrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentValidator implements Validator {

    private final StudentService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto dto = (StudentDto) target;
        if(!dto.getName().isEmpty()){
            Optional<Student> student = service.findByName(dto.getName());
            if(student.isPresent()){
                errors.rejectValue("name", null , "Already Exists");
            }
        }

    }
}
