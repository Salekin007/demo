package com.example.studentCrud.entity.composite;

import com.example.studentCrud.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@ToString(exclude = "student")
@EqualsAndHashCode(callSuper = false, exclude = "student")
public class StudentCoursePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @Column(name = "COURSE_ID", nullable = false)
    private Long courseId;

    public StudentCoursePK(Student student, Long courseId) {
        this.student = student;
        this.courseId = courseId;
    }
}
