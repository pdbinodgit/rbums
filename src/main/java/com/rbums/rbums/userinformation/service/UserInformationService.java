package com.rbums.rbums.userinformation.service;

import com.rbums.rbums.userinformation.dto.UserInformationDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserInformationService {

     UserInformationDto  saveUserInformation(UserInformationDto userInformationDto);

     List<UserInformationDto> getAllUser();

     UserInformationDto getByUserId();

     List<UserInformationDto> searchByName(String keyboard);

     void updateUserInformation(UserInformationDto userInformationDto);

}
