package com.example.studentCrud.entity;

import com.example.studentCrud.enums.Gender;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "STUDENT_ONE")
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Long id;

    @Column(name = "STUDENT_NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Student_Gender")
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "Class_Name_ID")
    private ClassName className;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "STUDENT_ID")
    private List<Enclosure> enclosure;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "STUDENT_ID")
    @ToString.Exclude
    private List<Attendance> attendanceList;

    public void addAttendence(List<Attendance> attendance) {
        if (this.attendanceList == null) {
            this.attendanceList = new ArrayList<>();
        }
        this.attendanceList.addAll(attendance);
    }

    public void addEnclosures(List<Enclosure> encloser) {
        if (this.enclosure == null) {
            this.enclosure = new ArrayList<>();
        }
        this.enclosure.addAll(encloser);
    }
}
