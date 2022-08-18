package com.example.studentCrud.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

//
//@Data
//@Entity
//@Table(name = "ENCLOSURE")
//public class Enclosure
//{
//    @Id
//    @Autowired
//    @NotNull
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ENCLOSURE_ID")
//    private Long id;
//
//    @Column(name = "ENCLOSURE_NAME")
//    private String name;
//
//    @Column(name = "ENCLOSURE_URL")
//    private String url;
//
//}
//
//import com.sun.istack.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.*;
@Data
@Entity
@Table(name = "ENCLOSURE")
public class Enclosure {

    @Id
    @Autowired
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENCLOSURE_ID")
    private Long id;

    @Column(name = "ENCLOSURE_NAME")
    private String name;

    @Column(name = "ENCLOSURE_URL")
    private String url;
}