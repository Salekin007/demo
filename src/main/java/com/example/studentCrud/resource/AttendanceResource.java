package com.example.studentCrud.resource;

import com.example.studentCrud.dto.StudentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.example.studentCrud.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/attendance")
@Api(tags = "attendance's data")
public class AttendanceResource {
    private Map<Long, String> map= new HashMap<>();


    public AttendanceResource(){
        map.put(1L,"Amit");
        map.put(5L,"Rahul");
        map.put(2L,"Jai");
        map.put(6L,"Amit");
    }
    @GetMapping("/find")
    @ApiOperation(value = "Get attendance by id", response = String.class)
    public ResponseEntity<JSONObject> findAll() {
        return ok(success(map).getJson());
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Get attendance by id", response = String.class)
    public ResponseEntity<?> findById(@PathVariable final long id) {
        StudentDto studentDto = new StudentDto();
        map.forEach(
                (key, value) -> {
                    if (key.equals(id)){
                        studentDto.setId(key);
                        studentDto.setName(value);
                    }
                }
        );
        return ok(success(studentDto).getJson());
    }
}
