package com.rbums.rbums.attendance.serviceImpl;

import com.rbums.rbums.attendance.dto.AttendanceDto;
import com.rbums.rbums.attendance.model.Attendance;
import com.rbums.rbums.attendance.repository.AttendanceRepository;
import com.rbums.rbums.attendance.service.AttendanceService;
import com.rbums.rbums.mapperinterface.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    AttendanceMapper attendanceMapper;

    @Override
    public AttendanceDto saveAttendance(AttendanceDto attendanceDto) {

        Attendance attendance=attendanceMapper.dtoToEntity(attendanceDto);
        return attendanceMapper.entityToDto(attendanceRepository.save(attendance));
    }
}
