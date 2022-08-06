package com.example.studentCrud.entity;

import com.example.studentCrud.enums.RecordStatus;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@RequiredArgsConstructor
@Table(name= "CLASS_NAME")
public class ClassName extends BaseEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_NAME_ID")
    private Long id;

    @Column(name = "ClASS_NAME")
    private String className;

}
