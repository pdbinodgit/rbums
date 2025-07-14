package com.rbums.rbums.bankdetails.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDetailsDto {

    private Long id;

    @NotBlank(message = "Bank name is required")
    private String bankName;

    private String phoneNumber;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    private String branch;
    @NotBlank(message = "Account type is required")
    private String accountType;
}
