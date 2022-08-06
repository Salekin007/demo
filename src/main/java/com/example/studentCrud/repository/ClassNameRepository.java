package com.example.studentCrud.repository;

import com.example.studentCrud.entity.ClassName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, Long>{

    Optional<ClassName> findById(Integer id);

    Optional<ClassName> findByClassName(String className);


    @Query("SELECT c FROM ClassName c WHERE LOWER(c.className) LIKE LOWER(CONCAT('%', :className, '%'))")
    Page<ClassName> searchClassName(String className, Pageable pageable);
}
