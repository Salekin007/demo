package com.example.studentCrud.dto;

import com.example.studentCrud.entity.ClassName;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClassNameDTO {
    private Long id;

    @NotNull
    private  String className;

    public static ClassNameDTO response(ClassName className){
        ClassNameDTO dto = new ClassNameDTO();
        dto.setId(className.getId());
        dto.setClassName(className.getClassName());
        return dto;
    }

    public ClassName to(){
        ClassName className = new ClassName();
        className.setClassName(this.getClassName());
        return className;
    }

    public ClassName update(ClassName className){
        className.setClassName(this.className);
        return className;
    }
}
