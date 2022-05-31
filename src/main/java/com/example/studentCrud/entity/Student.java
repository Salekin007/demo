package com.example.studentCrud.entity;

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
    @ToString.Exclude
    private List<Course> courseList;
//
//    @OneToOne
//    @JoinColumn(name = "STUDENT_ID")
//    private Enclosure enclosure;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "STUDENT_ID")
    @ToString.Exclude
    List<Enclosure> enclosure;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "STUDENT_ID")
    @ToString.Exclude
    private List<StudentCourse> studentCourses;

    public void addEnclosures(List<Enclosure> encloser) {
        if (this.enclosure == null) {
            this.enclosure = new ArrayList<>();
        }
        this.enclosure.addAll(encloser);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
