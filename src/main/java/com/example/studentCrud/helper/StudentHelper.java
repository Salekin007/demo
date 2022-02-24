package com.example.studentCrud.helper;

import com.example.studentCrud.dto.StudentCourseDTO;
import com.example.studentCrud.dto.StudentCourseListDTO;
import com.example.studentCrud.entity.Enclosure;
import com.example.studentCrud.entity.Student;
import com.example.studentCrud.entity.StudentCourse;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.utils.FileUpload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class StudentHelper  extends FileUpload {

    @Resource
    private Environment env;

    public void getSaveData(Student student, RecordStatus recordStatus) {
        student.setRecordStatus(recordStatus);
    }

    public void getUpdateData(Student student, RecordStatus status) {
        student.setRecordStatus(status);
    }

    public List<Enclosure> getStudentEnclosers(
            MultipartFile file1,
            String request1,
            Student student) throws JsonProcessingException {

        List<Enclosure> enclosers = new ArrayList<>();
        if (student.getEnclosure() != null) {
            if (!student.getEnclosure().isEmpty()) {
                List<Enclosure> lists = new ArrayList<>(student.getEnclosure());
                enclosers.addAll(lists);
            }
        }

        Enclosure encloser_1 = new ObjectMapper().readValue(request1, Enclosure.class);

        enclosers.add(encloser_1);

        if (nonNull(file1)) {
            setEncloserFile(encloser_1, file1);
        }
        return enclosers;
    }

    public void setStudentCourse(StudentCourseListDTO studentCourseListDTO, Student student) {
        student.getStudentCourses().clear();
        if(Objects.isNull(studentCourseListDTO)
                || Objects.isNull(studentCourseListDTO.getStudentCourses())){
            return;
        }
        for(StudentCourseDTO studentCourseDTO : studentCourseListDTO.getStudentCourses()){
            StudentCourse studentCourse = studentCourseDTO.toEntity(student);
//            setBaseEntityProperties(studentCourse, recordStatus);
        }
    }

    public void setEncloserFile(
            Enclosure encloser_1,
            MultipartFile file1) {
        encloser_1.setUrl(upload(file1, env.getProperty("ftpFileUploadPath")));
    }
}
