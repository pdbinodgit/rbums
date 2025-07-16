package com.rbums.rbums.mapperinterface;

import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.model.UserInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {AddressMapper.class, BankDetailsMapper.class, RoleMapper.class})
public interface UserInformationMapper {

     @Mapping(source = "addressDto", target = "address")
     @Mapping(source = "bankDetailsDtos", target = "bankDetails")
     @Mapping(source = "roleDtos",target = "roles")
     UserInformation dtoToEntity(UserInformationDto userInformationDto);

     @Mapping(source = "address", target = "addressDto")
     @Mapping(source = "bankDetails", target = "bankDetailsDtos")
     @Mapping(source = "roles",target = "roleDtos")
     UserInformationDto entityToDto(UserInformation userInformation);
}
