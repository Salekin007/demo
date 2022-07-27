package com.example.studentCrud.resource;


import com.example.studentCrud.dto.AttendanceClassDto;
import com.example.studentCrud.entity.AttendanceClass;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.service.AttendanceClassService;
import com.example.studentCrud.utils.CommonDataHelper;
import com.example.studentCrud.validation.AttendanceClassValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.studentCrud.exception.ApiError.fieldError;
import static com.example.studentCrud.utils.ResponseBuilder.error;
import static com.example.studentCrud.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/attendanceClass")
@Api(tags = "Attendance Class data")
public class AttendanceClassResource {
    private final AttendanceClassService service;

    private final CommonDataHelper helper;

    private final AttendanceClassValidator validator;

//    private final StudentService studentService;

    @RequestMapping(
            path = "/save",
            method = RequestMethod.POST)
    @ApiOperation(value = "save Attendance Class info", response = String.class)
    public ResponseEntity<JSONObject> save(@RequestBody AttendanceClassDto dto, BindingResult bindingResult) {

        ValidationUtils.invokeValidator(validator, dto, bindingResult);
        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }

        AttendanceClass attendanceClass = service.insertAttendance(dto, RecordStatus.DRAFT);

        return ok(success(AttendanceClassDto.response(attendanceClass), "Attendance Class Save Successfully").getJson());
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findById(@PathVariable Long id) {

        Optional<AttendanceClass> attendanceClass = service.findById(id, RecordStatus.DRAFT);

        return ok(success(attendanceClass).getJson());
    }

    @GetMapping("/find/All")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findAll() {

        List<AttendanceClass> attendanceClasses = service.findAll();

        return ok(success(attendanceClasses).getJson());
    }

    //    @GetMapping("/find/studentId")
//    @ResponseBody
//    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
//    public ResponseEntity<JSONObject> findAll(@RequestParam Long studentId) {
//
//        List<Attendance> attendance = service.findByStudentId(studentId);
//
//        return ok(success(attendance).getJson());
//    }
//    @GetMapping("/find/ByAttendance")
//    @ResponseBody
//    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
//    public ResponseEntity<JSONObject> findbyAttendance(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
//
//        List<Attendance> attendance = service.findbyAttendance(page, size);
//
//        return ok(success(attendance).getJson());
//    }
    @PutMapping("/update")
    // @ApiOperation(value = "Update qouta", response = QoutaRequest.class)
    public ResponseEntity<JSONObject> update(@RequestBody AttendanceClassDto dto, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }


        AttendanceClass attendanceClass = service.update(dto, RecordStatus.DRAFT);

        return ok(success(AttendanceClassDto.response(attendanceClass), "Attendance Class Edited Successfully").getJson());
    }
//    @PutMapping("/change-record-status/{id}/{status}")
//    @ApiOperation(value = "Attendance status update", response = String.class)
//    public ResponseEntity<JSONObject> changeRecordStatus(@PathVariable Long id, @PathVariable RecordStatus status) {
//
//        service.updateRecordStatus(id, status);
//        return ok(success(null, status.toString().toLowerCase() + " successfully").getJson());
//
//    }
}
