package com.example.studentCrud.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "STUDENT")
public class Student extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Long id;

    @Column (name = "STUDENT_NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "STUDENT_ID")
    private List<Course> courseList;
//
//    @OneToOne
//    @JoinColumn(name = "STUDENT_ID")
//    private Enclosure enclosure;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "STUDENT_ID")
    List<Enclosure> enclosure;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "STUDENT_ID")
    private List<StudentCourse> studentCourses;

    public void addEnclosures(List<Enclosure> encloser) {
        if (this.enclosure == null) {
            this.enclosure = new ArrayList<>();
        }
        this.enclosure.addAll(encloser);
    }
}
