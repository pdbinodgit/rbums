package com.rbums.rbums.attendance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AttendanceDto {
    private Long id;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private boolean presentStatus;
}
