package com.rbums.rbums.mapperinterface;


import com.rbums.rbums.attendance.dto.AttendanceDto;
import com.rbums.rbums.attendance.model.Attendance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    Attendance dtoToEntity(AttendanceDto attendanceDto);

    AttendanceDto entityToDto(Attendance attendance);
}
