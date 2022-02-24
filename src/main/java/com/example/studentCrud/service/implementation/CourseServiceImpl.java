package com.example.studentCrud.service.implementation;

import com.example.studentCrud.dto.CourseDto;
import com.example.studentCrud.entity.Course;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.exception.ResourceNotFoundException;
import com.example.studentCrud.helper.CourseHelper;
import com.example.studentCrud.repository.CourseRepository;
import com.example.studentCrud.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

private final CourseRepository repository;
private final CourseHelper helper;
private final EntityManager em;


    @Override
    public Map<String, Object> getList(String name, Integer page, Integer size) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Optional<Course> findById(Long id, RecordStatus recordStatus) {
        Optional<Course> course = repository.findById(id);
        return course;
    }

    @Override
    public Optional<Course> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    @Transactional
    public Course insertCourse(CourseDto dto, RecordStatus recordStatus) {
       Course course = dto.to();
       helper.getSaveData(course, recordStatus);
       Course saveCourse = repository.save(course);
       return saveCourse;
    }

    @Override
    @Transactional
    public Course update(CourseDto dto, RecordStatus recordStatus) {
        Course course = repository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Course Id: " + dto.getId()));

        dto.update(course);
        helper.getUpdateData(course, recordStatus);

        Course updatedCourse = repository.save(course);
        return updatedCourse;
    }

}
