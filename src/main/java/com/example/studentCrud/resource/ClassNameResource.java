package com.example.studentCrud.resource;

import com.example.studentCrud.dto.ClassNameDTO;
import com.example.studentCrud.entity.ClassName;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.service.ClassNameService;
import com.example.studentCrud.utils.CommonDataHelper;
import com.example.studentCrud.validation.ClassNameVaildator;
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
@RequestMapping("api/v1/ClassName")
@Api(tags = "ClassName info")
public class ClassNameResource {

    private final ClassNameVaildator validator;

    private final ClassNameService service;

    private final CommonDataHelper helper;

    @RequestMapping(
            path = "/save",
            method = RequestMethod.POST)
    // @ApiOperation(value = "save student info with Image image", response = String.class)
    public ResponseEntity<JSONObject> save(@RequestBody ClassNameDTO dto, BindingResult bindingResult) {

        //  log.info("Got request for creating a student.");
        ValidationUtils.invokeValidator(validator, dto, bindingResult);

        if (bindingResult.hasErrors()) {
            // error handling code goes here.
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }
        ClassName className = service.insertClassName(dto, RecordStatus.DRAFT);
        return ok(success(ClassNameDTO.response(className), "Class Name Save Successfully").getJson());
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    //@ApiOperation(value = "Get student by id", response = StudentResponse.class)
    public ResponseEntity<JSONObject> findById(@PathVariable Long id) {

        Optional<ClassName> className = service.findById(id, RecordStatus.DRAFT);

        return ok(success(className).getJson());
    }

    @PutMapping("/update")
    // @ApiOperation(value = "Update qouta", response = QoutaRequest.class)
    public ResponseEntity<JSONObject> update(@RequestBody ClassNameDTO dto, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return badRequest().body(error(fieldError(bindingResult)).getJson());
        }


        ClassName className = service.update(dto, RecordStatus.DRAFT);

        return ok(success(ClassNameDTO.response(className), "Course Edited Successfully").getJson());
    }




}
