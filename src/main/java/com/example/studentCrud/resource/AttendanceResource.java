package com.example.studentCrud.resource;


import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.service.AttendanceService;
import com.example.studentCrud.utils.CommonDataHelper;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.example.studentCrud.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/attendance")
@Api(tags = "Attendance's data")
public class AttendanceResource {
    private final AttendanceService service;

    private final CommonDataHelper helper;

    @RequestMapping(
            path = "/save",
            method = RequestMethod.POST)
    // @ApiOperation(value = "save student info with Image image", response = String.class)
    public ResponseEntity<JSONObject> save(@RequestBody AttendanceDto dto, BindingResult bindingResult) {
        Attendance attendance = service.insertAttendance(dto, RecordStatus.DRAFT);
        return ok(success(AttendanceDto.response(attendance), "Attendance Save Successfully").getJson());
    }
}
