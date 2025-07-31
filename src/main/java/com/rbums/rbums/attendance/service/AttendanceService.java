package com.rbums.rbums.attendance.service;

import com.rbums.rbums.attendance.dto.AttendanceDto;

public interface AttendanceService {

    public void saveAttendance(AttendanceDto attendanceDto);

    public void updateAttendance(AttendanceDto attendanceDto);
}
