package com.example.studentCrud.validation;

import com.example.studentCrud.dto.ClassNameDTO;
import com.example.studentCrud.entity.ClassName;
import com.example.studentCrud.service.ClassNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class ClassNameVaildator implements Validator {

    private final ClassNameService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return ClassNameDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClassNameDTO dto = (ClassNameDTO) target;
        if(!dto.getClassName().isEmpty()){
            Optional<ClassName> course = service.findByName(dto.getClassName());
            if(course.isPresent()){
                errors.rejectValue("className", null , "Already Exists");
            }
        }

    }
}
