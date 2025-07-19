package com.rbums.rbums.userinformation.service;

import com.rbums.rbums.userinformation.dto.UserInformationDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserInformationService {

     UserInformationDto  saveUserInformation(UserInformationDto userInformationDto);

     Page<UserInformationDto> getAllUser(int number,int size);

     UserInformationDto getByUserId();

     Page<UserInformationDto> searchByName(String keyboard,int number,int size);

     void updateUserInformation(UserInformationDto userInformationDto);

}
