package com.rbums.rbums.role.serviceImpl;

import com.rbums.rbums.customException.RbumsCustomException;
import com.rbums.rbums.mapperinterface.RoleMapper;
import com.rbums.rbums.role.dto.RoleDto;
import com.rbums.rbums.role.model.Role;
import com.rbums.rbums.role.repository.RoleRepository;
import com.rbums.rbums.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public RoleDto saveRole(RoleDto roleDto) {

        Role role=roleMapper.dtoToEntity(roleDto);
        Optional<Role> roleOptional=roleRepository.findByRoleName(role.getRoleName());
        if (roleOptional.isPresent()){
            throw new RbumsCustomException("Role name already present", HttpStatus.BAD_REQUEST,400);
        }
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
