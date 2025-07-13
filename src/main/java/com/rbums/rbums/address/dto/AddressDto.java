package com.rbums.rbums.address.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private Long id;

    @NotBlank(message = "District is required.")
    private String district;
    @NotBlank(message = "Municipality is required.")
    private String municipality;

    private long wardNo;

    private String country;
}
