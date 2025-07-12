package com.rbums.rbums.userinformation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserInformationDto {
    private String  firstName;

    private String middleName;

    private String lastName;

    private Long age;

    private LocalDate dateOfBirth;

    private String username;

    private String password;
}
