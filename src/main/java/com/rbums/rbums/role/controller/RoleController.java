package com.rbums.rbums.role.controller;

import com.rbums.rbums.customresponse.ApiResponse;
import com.rbums.rbums.role.dto.RoleDto;
import com.rbums.rbums.role.model.Role;
import com.rbums.rbums.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/saveRole")
    public ResponseEntity<ApiResponse<?>> saveRole(@RequestBody RoleDto roleDto){
        RoleDto dto=roleService.saveRole(roleDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Role save successfully",dto));
    }


    @GetMapping("/getAllRole")
   public ResponseEntity<ApiResponse<?>> getAllRole(){
       return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Role retrieve successfully",roleService.getAllRole()));

   }
}
