package com.example.studentCrud.helper;

import com.example.studentCrud.entity.Attendance;
import com.example.studentCrud.enums.RecordStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendanceHelper {

    public void getSaveData(Attendance attendance, RecordStatus recordStatus) {
        attendance.setRecordStatus(recordStatus);
    }

    public void getUpdateData(Attendance attendance, RecordStatus status) {
        attendance.setRecordStatus(status);
    }
}
