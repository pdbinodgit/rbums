package com.rbums.rbums.mapperinterface;

import com.rbums.rbums.role.dto.RoleDto;
import com.rbums.rbums.role.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role dtoToEntity(RoleDto roleDto);
    RoleDto entityToDto(Role role);
}
