package com.rbums.rbums.attendance.controller;

import com.rbums.rbums.attendance.dto.AttendanceDto;
import com.rbums.rbums.attendance.service.AttendanceService;
import com.rbums.rbums.customresponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @PostMapping("/checkIn")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApiResponse<?>> saveAttendance(@RequestBody AttendanceDto attendanceDto){
        attendanceService.saveAttendance(attendanceDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Check in successfully."));
    }

    @PostMapping("/checkIn")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApiResponse<?>> updateAttendance(@RequestBody AttendanceDto attendanceDto){
        attendanceService.updateAttendance(attendanceDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Check out successfully."));
    }
}
