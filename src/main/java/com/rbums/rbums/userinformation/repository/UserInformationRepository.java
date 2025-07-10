package com.rbums.rbums.userinformation.repository;

import com.rbums.rbums.userinformation.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,Long> {

    public Optional<UserInformation> findByUsername(String username);

}
