package com.rbums.rbums.mapperinterface;

import com.rbums.rbums.bankdetails.dto.BankDetailsDto;
import com.rbums.rbums.bankdetails.model.BankDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankDetailsMapper {

     BankDetails dtoToEntity(BankDetailsDto bankDetailsDto);

     BankDetailsDto entityToDto(BankDetails bankDetails);


}
