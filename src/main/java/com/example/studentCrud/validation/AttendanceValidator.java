//package com.example.studentCrud.validation;
//
//import com.example.studentCrud.dto.AttendanceDto;
//import com.example.studentCrud.entity.Attendance;
//import com.example.studentCrud.service.AttendanceService;
//import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import java.util.Optional;
//
//@Component
//@RequiredArgsConstructor
//public class AttendanceValidator implements Validator {
//
//    private final AttendanceService service;
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return AttendanceDto.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        AttendanceDto dto = (AttendanceDto) target;
//        if(!dto.getName().isEmpty()){
//            Optional<Attendance> course = service.findByName(dto.getName());
////            AnnotationCollector.EmptyCollector attendance = null;
////            if(attendance.isPresent()){
////                errors.rejectValue("name", null , "Already Exists");
////            }
//        }
//
//    }
//}
