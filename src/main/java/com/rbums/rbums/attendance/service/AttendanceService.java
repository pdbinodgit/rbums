package com.rbums.rbums.attendance.service;

import com.rbums.rbums.attendance.dto.AttendanceDto;

public interface AttendanceService {

    public AttendanceDto saveAttendance(AttendanceDto attendanceDto);

    public AttendanceDto updateAttendance(AttendanceDto attendanceDto);
}
