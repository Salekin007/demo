package com.example.studentCrud.entity;

import com.example.studentCrud.entity.composite.StudentCoursePK;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "STUDENT_COURSE")
public class StudentCourse extends BaseEntity {

    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    private StudentCoursePK pk;

    @Column(name = "DURATION")
    private String duration;

//    @Version
//    @Column(name = "RECORD_VERSION")
//    protected long version;
}

