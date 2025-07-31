package com.rbums.rbums.attendance.serviceImpl;

import com.rbums.rbums.attendance.dto.AttendanceDto;
import com.rbums.rbums.attendance.model.Attendance;
import com.rbums.rbums.attendance.repository.AttendanceRepository;
import com.rbums.rbums.attendance.service.AttendanceService;
import com.rbums.rbums.customException.RbumsCustomException;
import com.rbums.rbums.mapperinterface.AttendanceMapper;
import com.rbums.rbums.userinformation.model.UserInformation;
import com.rbums.rbums.userinformation.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    UserInformationRepository userInformationRepository;

    @Autowired
    AttendanceMapper attendanceMapper;

    @Override
    public void saveAttendance(AttendanceDto attendanceDto) {

        Attendance attendance=attendanceMapper.dtoToEntity(attendanceDto);
    }

    @Override
    public void updateAttendance(AttendanceDto attendanceDto) {
        String username=SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<UserInformation> userInformationOptional=userInformationRepository.findByUsername(username);
        if (!userInformationOptional.isPresent()){
            throw new RbumsCustomException("User not found", HttpStatus.INTERNAL_SERVER_ERROR,500);
        }
        Optional<Attendance> attendanceOptional=attendanceRepository.findAttendanceByUserIdAndPresentStatus(userInformationOptional.get().getId(),true);
        if (!attendanceOptional.isPresent()){
            throw new RbumsCustomException("Something wrong!!",HttpStatus.INTERNAL_SERVER_ERROR,500);
        }
        attendanceOptional.get().setCheckOut(LocalDateTime.now());
        if (LocalTime.now().isAfter(LocalTime.of(6,45))){
            attendanceOptional.get().setRemark("Late checkout");
        }
        attendanceOptional.get().setPresentStatus(false);
        attendanceRepository.save(attendanceOptional.get());
    }
}
