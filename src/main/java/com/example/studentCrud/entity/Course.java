package com.example.studentCrud.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "COURSE")
public class Course extends BaseEntity {
    @Id

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Long id;

    @Column(name = "COURSE_NAME")
    private String name;

    @Column(name = "COURSE_DURATION")
    private String duration;

    @ManyToOne
    @JoinColumn(name = "CLASS_NAME_ID")
    private ClassName className;

}
