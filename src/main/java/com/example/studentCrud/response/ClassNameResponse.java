package com.example.studentCrud.response;


import com.example.studentCrud.entity.ClassName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassNameResponse {
    private Long id;

    private String className;


    public static ClassNameResponse response(ClassName className) {
        ClassNameResponse response = new ClassNameResponse();
        response.setId(className.getId());
        response.setClassName(className.getClassName());
        return response;
    }
}
