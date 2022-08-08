package com.example.studentCrud.dto;

import com.example.studentCrud.entity.Course;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CourseDto {

    private Long id;

    private Long classNameId;

    @NotNull
    private String name;

    @NotNull
    private String duration;


    public static CourseDto response(Course course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setClassNameId(course.getClassName().getId());
        dto.setName(course.getName());
        dto.setDuration(course.getDuration());
        return dto;
    }

    public Course to() {
        Course course = new Course();
        course.setName(this.name);
        course.setDuration(this.duration);
        return course;
    }

    public Course update(Course course) {
        course.setName(this.name);
        course.setDuration(this.duration);
        return course;
    }

}

