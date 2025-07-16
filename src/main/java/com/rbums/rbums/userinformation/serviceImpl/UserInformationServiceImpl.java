package com.rbums.rbums.userinformation.serviceImpl;

import com.rbums.rbums.bankdetails.model.BankDetails;
import com.rbums.rbums.customException.RbumsCustomException;
import com.rbums.rbums.mapperinterface.UserInformationMapper;
import com.rbums.rbums.role.model.Role;
import com.rbums.rbums.role.repository.RoleRepository;
import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.model.UserInformation;
import com.rbums.rbums.userinformation.repository.UserInformationRepository;
import com.rbums.rbums.userinformation.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserInformationRepository userInformationRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    private final UserInformationMapper userInformationMapper;

    public UserInformationServiceImpl(UserInformationMapper userInformationMapper) {
        this.userInformationMapper = userInformationMapper;
    }

    @Override
    public UserInformationDto saveUserInformation(UserInformationDto userInformationDto) {
        Optional<UserInformation> userInformationOptional=userInformationRepository.findByUsername(userInformationDto.getUsername());
        if (userInformationOptional.isPresent()){
            throw new RbumsCustomException("Username is already exist.", HttpStatus.BAD_REQUEST,400);
        }

        UserInformation userInformation=userInformationMapper.dtoToEntity(userInformationDto);

        for (BankDetails details:userInformation.getBankDetails()){
            details.setUserInformation(userInformation);
        }
       for (Role role: userInformation.getRoles()){
           userInformation.getRoles().add(role);
       }
       userInformation.setPassword(passwordEncoder.encode(userInformation.getPassword()));

        UserInformation userInformation1=  userInformationRepository.save(userInformation);

        return userInformationMapper.entityToDto(userInformation1);
    }

    @Override
    public List<UserInformationDto> getAllUser() {

        List<UserInformation> userInformationList=userInformationRepository.findAll();

        List<UserInformationDto> userInformationDtos=new ArrayList<>();
        for (UserInformation userInformation:userInformationList){
            userInformationDtos.add(userInformationMapper.entityToDto(userInformation));
        }
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
