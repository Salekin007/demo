package com.example.studentCrud.helper;
import com.example.studentCrud.entity.ClassName;
import com.example.studentCrud.entity.ClassName;
import com.example.studentCrud.enums.RecordStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClassNameHelper {

    public void getSaveData(ClassName className, RecordStatus recordStatus){
        className.setRecordStatus(recordStatus);
    }

    public void getUpdateData(ClassName className, RecordStatus status){
        className.setRecordStatus(status);
    }

}
