package com.rbums.rbums.userinformation.controller;

import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInformationController {

    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/saveUser")
    ResponseEntity<String> saveUserInformation(UserInformationDto userInformationDto){
        userInformationService.saveUserInformation(userInformationDto);
        return ResponseEntity.ok("Save user information");
    }

    @GetMapping("/getAllUser")
    List<UserInformationDto> getAllUser(){
        return userInformationService.getAllUser();
    }
}
