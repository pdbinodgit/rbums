package com.rbums.rbums.role.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private Long id;

    @NotBlank(message = "Role name is required.")
    private String roleName;
}
