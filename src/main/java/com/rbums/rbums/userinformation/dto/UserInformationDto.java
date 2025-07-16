package com.rbums.rbums.userinformation.dto;

import com.rbums.rbums.address.dto.AddressDto;
import com.rbums.rbums.bankdetails.dto.BankDetailsDto;

import com.rbums.rbums.role.dto.RoleDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserInformationDto {

    private Long id;

    private String  firstName;

    private String middleName;

    private String lastName;

    private Long age;

    private LocalDate dateOfBirth;

    @NotBlank(message = "User name is required")
    private String username;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    private AddressDto addressDto;

    List<BankDetailsDto> bankDetailsDtos;

    Set<RoleDto> roleDtos=new HashSet<>();
}
