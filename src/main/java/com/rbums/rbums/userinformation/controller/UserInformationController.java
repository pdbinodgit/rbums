package com.rbums.rbums.userinformation.controller;

import com.rbums.rbums.customresponse.ApiResponse;
import com.rbums.rbums.role.dto.RoleDto;
import com.rbums.rbums.role.repository.RoleRepository;
import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.service.UserInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserInformationController {

    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/saveUser")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<ApiResponse<?>> saveUserInformation(@RequestBody @Valid UserInformationDto userInformationDto){
      UserInformationDto dto=  userInformationService.saveUserInformation(userInformationDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information saved successfully",dto));
    }

    @GetMapping("/getAllUser")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<ApiResponse<?>> getAllUser(@RequestParam int number,@RequestParam int size){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information retrieve successfully",userInformationService.getAllUser(number,size)));
    }
    @GetMapping("/getUserPersonalInformation")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> getByUserId(@RequestParam(required = false) Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information retrieve successfully",userInformationService.getByUserId(id)));

    }
    @GetMapping("/searchByName")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> searchByName(@RequestParam String keyword,
                                                       @RequestParam int number,
                                                       @RequestParam int size){

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information retrieve successfully",userInformationService.searchByName(keyword,number,size)));
    }

    @PutMapping("/updateUserInformation/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> updateUserInformation(@RequestBody UserInformationDto userInformationDto,@PathVariable Long id){
        userInformationService.updateUserInformation(userInformationDto,id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information update successfully"));
    }

    @PutMapping("/updateRole/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<?>> updateRoleInformation(@RequestBody Set<RoleDto> roleDtos, @PathVariable Long id){
        userInformationService.userRoleUpdate(roleDtos,id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User role update successfully"));
    }

}
