package com.rbums.rbums.attendance.repository;

import com.rbums.rbums.attendance.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {


    Optional<Attendance> findAttendanceByUserIdAndPresentStatus( Long userId,boolean b);
;
}
