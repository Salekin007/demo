package com.example.studentCrud.service.implementation;


import com.example.studentCrud.dto.ClassNameDTO;
import com.example.studentCrud.entity.ClassName;
import com.example.studentCrud.enums.RecordStatus;
import com.example.studentCrud.exception.ResourceNotFoundException;
import com.example.studentCrud.helper.ClassNameHelper;
import com.example.studentCrud.repository.ClassNameRepository;
import com.example.studentCrud.service.ClassNameService;
import javassist.bytecode.stackmap.TypeData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassNameServiceImpl implements ClassNameService {

    private final ClassNameRepository repository;
    private final ClassNameHelper helper;
    private final EntityManager em;


    @Override
    public Map<String, Object> getList(String name, Integer page, Integer size) {
        return null;
    }

    @Override
    public List<ClassName> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClassName> findById(Long id, RecordStatus recordStatus) {
        Optional<ClassName> className = repository.findById(id);
        return className;
    }

    @Override
    public Optional<ClassName> findByName(String name) {
        return repository.findByClassName(name);
    }

    @Override
    @Transactional
    public ClassName insertClassName(ClassNameDTO dto, RecordStatus recordStatus) {
        ClassName className = dto.to();
        helper.getSaveData(className, recordStatus);
        ClassName saveClassName = repository.save(className);
        return saveClassName;
    }

    @Override
    @Transactional
    public ClassName update(ClassNameDTO dto, RecordStatus recordStatus) {
        ClassName className = repository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("ClassName Id: " + dto.getId()));

        dto.update(className);
        helper.getUpdateData(className, recordStatus);

        ClassName updatedClassName = repository.save(className);
        return updatedClassName;
    }

}

