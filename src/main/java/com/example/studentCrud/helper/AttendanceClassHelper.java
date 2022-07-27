package com.example.studentCrud.helper;

import com.example.studentCrud.entity.AttendanceClass;
import com.example.studentCrud.enums.RecordStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendanceClassHelper {

    public void getSaveData(AttendanceClass attendanceClass, RecordStatus recordStatus) {
        attendanceClass.setRecordStatus(recordStatus);
    }

    public void getUpdateData(AttendanceClass attendanceClass, RecordStatus status) {
        attendanceClass.setRecordStatus(status);
    }
}
