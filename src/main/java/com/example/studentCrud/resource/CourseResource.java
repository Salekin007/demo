package com.example.studentCrud.resource;


import com.example.studentCrud.dto.CourseDto;
import com.example.studentCrud.entity.Course;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.service.CourseService;
import com.example.studentCrud.utils.CommonDataHelper;
import com.example.studentCrud.validation.CourseValidator;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.example.studentCrud.exception.ApiError.fieldError;
import static com.example.studentCrud.utils.ResponseBuilder.error;
import static com.example.studentCrud.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Course")
@Api(tags = "Course info")
public class CourseResource {

    private final CourseValidator validator;

    private final CourseService service;

    private final CommonDataHelper helper;

    @RequestMapping(
            path = "/save",
            method = RequestMethod.POST)
   // @ApiOperation(value = "save student info with Image image", response = String.class)
    public ResponseEntity<JSONObject> save(@RequestBody CourseDto dto, BindingResult bindingResult) {

        //  log.info("Got request for creating a student.");
        ValidationUtils.invokeValidator(validator, dto, bindingResult);

        if (bindingResult.hasErrors()) {
            // error handling code goes here.
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }
        Course course = service.insertCourse(dto, RecordStatus.DRAFT);
        return ok(success(CourseDto.response(course), "Course Save Successfully").getJson());
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findById(@PathVariable Long id) {

        Optional<Course> course = service.findById(id, RecordStatus.DRAFT);

        return ok(success(course).getJson());
    }

    @PutMapping("/update")
   // @ApiOperation(value = "Update qouta", response = QoutaRequest.class)
    public ResponseEntity<JSONObject> update(@RequestBody CourseDto dto, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }


        Course course = service.update(dto, RecordStatus.DRAFT);

        return ok(success(CourseDto.response(course), "Course Edited Successfully").getJson());
    }




}
