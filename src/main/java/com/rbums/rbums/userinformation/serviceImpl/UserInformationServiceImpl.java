package com.rbums.rbums.userinformation.serviceImpl;

import com.rbums.rbums.mapperinterface.UserInformationMapper;
import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.model.UserInformation;
import com.rbums.rbums.userinformation.repository.UserInformationRepository;
import com.rbums.rbums.userinformation.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserInformationRepository userInformationRepository;

    @Autowired
    UserInformationMapper userInformationMapper;

    @Override
    public void saveUserInformation(UserInformationDto userInformationDto) {
        userInformationRepository.save(userInformationMapper.dtoToEntity(userInformationDto));
    }

    @Override
    public List<UserInformationDto> getAllUser() {

        List<UserInformation> userInformationList=userInformationRepository.findAll();
        List<UserInformationDto> userInformationDtos=userInformationList.stream().map(
                userInformation ->
            userInformationMapper.entityToDto(userInformation)).toList();
        return userInformationDtos;
    }

    @Override
    public UserInformationDto getByUserId() {
        return null;
    }

    @Override
    public List<UserInformationDto> searchByName(String keyboard) {
        return List.of();
    }

    @Override
    public void updateUserInformation(UserInformationDto userInformationDto) {

    }
}
