package com.example.studentCrud.service;

import com.example.studentCrud.dto.ClassNameDTO;
import com.example.studentCrud.entity.ClassName;
import com.example.studentCrud.enums.RecordStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface ClassNameService {

    Map<String, Object> getList(String ClassName, Integer page, Integer size);

    List<ClassName> findAll();

    Optional<ClassName> findById(Long id, RecordStatus recordStatus);

    Optional<ClassName> findByName(String name);

    ClassName insertClassName(ClassNameDTO dto, RecordStatus recordStatus);

    ClassName update(ClassNameDTO dto, RecordStatus recordStatus);



}
