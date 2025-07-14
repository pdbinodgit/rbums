package com.rbums.rbums.role.service;

import com.rbums.rbums.role.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto saveRole(RoleDto roleDto);

    List<RoleDto> getAllRole();


}
