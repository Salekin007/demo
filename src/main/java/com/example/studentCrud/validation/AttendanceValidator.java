package com.example.studentCrud.validation;

import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

import static com.example.studentCrud.utils.StringUtils.isNotEmpty;

@Component
@RequiredArgsConstructor
public class AttendanceValidator implements Validator {

    private final AttendanceService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return AttendanceDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AttendanceDto dto = (AttendanceDto) target;
        if(!dto.getClassName().isEmpty()){
            Optional<Attendance> attendance = service.findByClassName(dto.getClassName());
            if(attendance.isPresent()){
                errors.rejectValue("className", null , "Already Exists");
            }
        }
        if (isNotEmpty(dto.getStartTime().toString()) & isNotEmpty(dto.getEndTime().toString())) {
            if (dto.getStartTime().after(dto.getEndTime())) {
                errors.rejectValue("endTime", null, "Start date is after than End date");
            }
        }
    }

}
