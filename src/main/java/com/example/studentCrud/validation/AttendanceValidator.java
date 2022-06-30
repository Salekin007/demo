package com.example.studentCrud.validation;

import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
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
        List<Attendance> attendances = service.findByStudentId(1L);
        attendances.forEach(attendance -> {
            if (getFormattedDatde(attendance.getStartTime()).equals(getFormattedDatde(dto.getStartTime())))
                errors.rejectValue("startTime", null, "Already Attendance Taken from you try next day");
        });
    }

    private String getFormattedDatde(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return  formatter.format(date);
    }

/*    public static void main(String[] args) {
        String sampleDate = "2022-06-30";
        Date date = new Date();
        System.out.println(date);
        String str = getFormattedDatde(date);
        System.out.println(str);
        System.out.println(str.equals(sampleDate));
    }*/

}
