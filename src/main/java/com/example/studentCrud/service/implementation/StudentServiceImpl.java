package com.example.studentCrud.service.implementation;

import com.example.studentCrud.dto.StudentCourseListDTO;
import com.example.studentCrud.dto.StudentDto;
import com.example.studentCrud.entity.Course;
import com.example.studentCrud.entity.Student;
import com.example.studentCrud.entity.StudentCourse;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.helper.StudentHelper;
import com.example.studentCrud.repository.StudentRepository;
import com.example.studentCrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    private final StudentHelper helper;

    private final EntityManager em;


    @Override
    public Map<String, Object> getList(String name, Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> findById(Long id, RecordStatus recordStatus) {
        return Optional.empty();
    }


    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Student> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Student insertCourse(StudentDto dto, RecordStatus recordStatus) {
        Student student = dto.to();
        helper.getSaveData(student, recordStatus);
        Student saveStudent = repository.save(student);
        return saveStudent;
    }

    @Override
    public Student update(StudentDto dto, RecordStatus recordStatus) {
        return null;
    }

    @Transactional
    public Student saveEncloser(Student student) {
        Student student2 = repository.save(student);
        return student2;
    }

    @Override
    public Student studentCourse(StudentCourseListDTO dto, Student student){
        helper.setStudentCourse(dto, student);
        repository.save(student);
        return student;
    }

}
