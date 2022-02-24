package com.example.studentCrud.validation;

import com.example.studentCrud.dto.CourseDto;
import com.example.studentCrud.entity.Course;
import com.example.studentCrud.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CourseValidator implements Validator {

    private final CourseService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return CourseDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseDto dto = (CourseDto) target;
        if(!dto.getName().isEmpty()){
            Optional<Course> course = service.findByName(dto.getName());
            if(course.isPresent()){
                errors.rejectValue("name", null , "Already Exists");
            }
        }

    }
}
