package com.rbums.rbums.mapperinterface;

import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.model.UserInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInformationMapper {

     UserInformation dtoToEntity(UserInformationDto userInformationDto);

     UserInformationDto entityToDto(UserInformation userInformation);
}
