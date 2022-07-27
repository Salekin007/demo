package com.example.studentCrud.validation;

import com.example.studentCrud.dto.AttendanceClassDto;
import com.example.studentCrud.entity.AttendanceClass;
import com.example.studentCrud.service.AttendanceClassService;
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
public class AttendanceClassValidator implements Validator {

    private final AttendanceClassService service;
    @Override
    public boolean supports(Class<?> clazz) {
        return AttendanceClassDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
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
