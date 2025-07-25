package com.rbums.rbums.userinformation.service;

import com.rbums.rbums.role.dto.RoleDto;
import com.rbums.rbums.userinformation.dto.UserInformationDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface UserInformationService {

     UserInformationDto  saveUserInformation(UserInformationDto userInformationDto);

     Page<UserInformationDto> getAllUser(int number,int size);

     UserInformationDto getByUserId(Long id);

     Page<UserInformationDto> searchByName(String keyboard,int number,int size);

     void updateUserInformation(UserInformationDto userInformationDto,Long id);

     void userRoleUpdate(Set<RoleDto> roleDtos, Long userId);

     void updateUserPassword(UserInformationDto userInformationDto, Long userId);

}
