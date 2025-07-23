package com.rbums.rbums.userinformation.serviceImpl;

import com.rbums.rbums.bankdetails.model.BankDetails;
import com.rbums.rbums.customException.RbumsCustomException;
import com.rbums.rbums.mapperinterface.UserInformationMapper;
import com.rbums.rbums.role.model.Role;
import com.rbums.rbums.role.repository.RoleRepository;
import com.rbums.rbums.securityconfig.JwtService;
import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.model.UserInformation;
import com.rbums.rbums.userinformation.repository.UserInformationRepository;
import com.rbums.rbums.userinformation.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    JwtService jwtService;


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
    public Page<UserInformationDto> getAllUser(int number,int size) {

        int totalNumber;
        Page<UserInformation> userInformationList=userInformationRepository.findAll(PageRequest.of(number,size));
        List<UserInformationDto> userInformationDtos=new ArrayList<>();
        for (UserInformation userInformation:userInformationList){
            userInformationDtos.add(userInformationMapper.entityToDto(userInformation));
        }
        totalNumber=userInformationDtos.size();

        return new PageImpl<>(userInformationDtos,PageRequest.of(number,size),totalNumber);
    }

    @Override
    public UserInformationDto getByUserId(Long id) {
        if (id==null) {

            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Optional<UserInformation> userInformationOptional = userInformationRepository.findByUsername(username);
            if (userInformationOptional.isPresent()) {
                return userInformationMapper.entityToDto(userInformationOptional.get());
            } else {
                throw new RbumsCustomException("User not found", HttpStatus.INTERNAL_SERVER_ERROR, 500);
            }
        }else {
            Optional<UserInformation> userInformationOptional=userInformationRepository.findById(id);

            if (userInformationOptional.isPresent()) {
                return userInformationMapper.entityToDto(userInformationOptional.get());
            } else {
                throw new RbumsCustomException("User not found", HttpStatus.INTERNAL_SERVER_ERROR, 500);
            }
        }

    }

    @Override
    public Page<UserInformationDto> searchByName(String keyboard,int number,int size) {

        int totalNumber;
        Page<UserInformation> userInformationList=userInformationRepository.findByName(keyboard,PageRequest.of(number,size));
        List<UserInformationDto> userInformationDtos=new ArrayList<>();
        for (UserInformation userInformation:userInformationList){
            userInformationDtos.add(userInformationMapper.entityToDto(userInformation));
        }
        totalNumber=userInformationDtos.size();

        return new PageImpl<>(userInformationDtos,PageRequest.of(number,size),totalNumber);

    }

    @Override
    public void updateUserInformation(UserInformationDto userInformationDto,Long id) {
        Optional<UserInformation> optionalUserInformation=userInformationRepository.findById(id);
        if (optionalUserInformation.isPresent()){
            optionalUserInformation.get().setFirstName(userInformationDto.getFirstName());
            optionalUserInformation.get().setDateOfBirth(userInformationDto.getDateOfBirth());
            optionalUserInformation.get().setMiddleName(userInformationDto.getMiddleName());
            optionalUserInformation.get().setLastName(userInformationDto.getLastName());
            userInformationRepository.save(optionalUserInformation.get());

        }else {
            throw new RbumsCustomException("User not found!!",HttpStatus.BAD_REQUEST,400);
        }


    }
}
