package com.rbums.rbums.mapperinterface;

import com.rbums.rbums.address.dto.AddressDto;
import com.rbums.rbums.address.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address dtoToEntity(AddressDto addressDto);
    AddressDto entityToDto(Address address);
}
