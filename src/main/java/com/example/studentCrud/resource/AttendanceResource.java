package com.example.studentCrud.resource;


import com.example.studentCrud.dto.AttendanceDto;
import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.entity.Student;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.exception.ResourceNotFoundException;
import com.example.studentCrud.service.AttendanceService;
import com.example.studentCrud.service.StudentService;
import com.example.studentCrud.utils.CommonDataHelper;
import com.example.studentCrud.validation.AttendanceValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("api/v1/attendance")
@Api(tags = "Attendance's data")
public class AttendanceResource {
    private final AttendanceService service;

    private final CommonDataHelper helper;

    private final AttendanceValidator validator;

    private final StudentService studentService;

    @RequestMapping(
            path = "/save",
            method = RequestMethod.POST)
    // @ApiOperation(value = "save student info with image", response = String.class)
    public ResponseEntity<JSONObject> save(@RequestBody AttendanceDto dto, BindingResult bindingResult) {

        ValidationUtils.invokeValidator(validator, dto, bindingResult);

        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }

        Student student = studentService.findById(dto.getStudentId()).orElseThrow(ResourceNotFoundException :: new);


//        Attendance attendance = service.insertAttendance(dto, RecordStatus.DRAFT);
        Attendance attendance = dto.to();
        List<Attendance> attendanceList = new ArrayList<>();
        attendanceList.add(attendance);
        student.addAttendence(attendanceList);
        studentService.saveEncloser(student);

        return ok(success(AttendanceDto.response(attendance), "Attendance Save Successfully").getJson());
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findById(@PathVariable Long id) {

        Optional<Attendance> attendance = service.findById(id, RecordStatus.DRAFT);

        return ok(success(attendance).getJson());
    }

    @GetMapping("/find/All")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findAll() {

        List<Attendance> attendance = service.findAll();

        return ok(success(attendance).getJson());
    }

    @GetMapping("/find/studentId")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findAll(@RequestParam Long studentId) {

        List<Attendance> attendance = service.findByStudentId(studentId);

        return ok(success(attendance).getJson());
    }
    @GetMapping("/find/ByAttendance")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findbyAttendance(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {

        List<Attendance> attendance = service.findbyAttendance(page, size);

        return ok(success(attendance).getJson());
    }
    @PutMapping("/update")
    // @ApiOperation(value = "Update qouta", response = QoutaRequest.class)
    public ResponseEntity<JSONObject> update(@RequestBody AttendanceDto dto, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }


        Attendance attendance = service.update(dto, RecordStatus.DRAFT);

        return ok(success(AttendanceDto.response(attendance), "Attendance Edited Successfully").getJson());
    }
    @PutMapping("/change-record-status/{id}/{status}")
    @ApiOperation(value = "Attendance status update", response = String.class)
    public ResponseEntity<JSONObject> changeRecordStatus(@PathVariable Long id, @PathVariable RecordStatus status) {

        service.updateRecordStatus(id, status);
        return ok(success(null, status.toString().toLowerCase() + " successfully").getJson());

    }
}
