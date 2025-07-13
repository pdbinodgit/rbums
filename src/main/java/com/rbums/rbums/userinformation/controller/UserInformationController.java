package com.rbums.rbums.userinformation.controller;

import com.rbums.rbums.customresponse.ApiResponse;
import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.service.UserInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInformationController {

    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/saveUser")
    ResponseEntity<ApiResponse<?>> saveUserInformation(@RequestBody @Valid UserInformationDto userInformationDto){
      UserInformationDto dto=  userInformationService.saveUserInformation(userInformationDto);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information saved successfully",dto));
    }

    @GetMapping("/getAllUser")
    ResponseEntity<ApiResponse<List<?>>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information retrieve successfully",userInformationService.getAllUser()));
    }
}
