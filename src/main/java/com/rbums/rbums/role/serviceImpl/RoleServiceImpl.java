package com.rbums.rbums.role.serviceImpl;

import com.rbums.rbums.mapperinterface.RoleMapper;
import com.rbums.rbums.role.dto.RoleDto;
import com.rbums.rbums.role.model.Role;
import com.rbums.rbums.role.repository.RoleRepository;
import com.rbums.rbums.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Role role=roleMapper.dtoToEntity(roleDto);
        roleRepository.save(role);
        RoleDto dto=roleMapper.entityToDto(role);
        return dto;
    }

    @Override
    public List<RoleDto> getAllRole() {
        List<Role> roleList=roleRepository.findAll();
        List<RoleDto> dtoList=new ArrayList<>();
        for (Role role:roleList){
            dtoList.add(roleMapper.entityToDto(role));
        }
        return dtoList;
    }
}
