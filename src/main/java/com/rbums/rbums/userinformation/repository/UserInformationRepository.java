package com.rbums.rbums.userinformation.repository;

import com.rbums.rbums.userinformation.dto.UserInformationDto;
import com.rbums.rbums.userinformation.model.UserInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,Long> {

    public Optional<UserInformation> findByUsername(String username);

   /*
   note : exact match
   @Query("select u from UserInformation u where  CONCAT (u.firstName , ' ' , u.middleName , ' ' , u.lastName ) = :name ")
    public Page<UserInformation> findByName(@Param("name") String name, Pageable pageable);*/


    @Query("select u from UserInformation u where " +
            "LOWER(u.firstName) LIKE LOWER(CONCAT('%',:name,'%')) or " +
            "LOWER(u.middleName) LIKE LOWER(CONCAT('%',:name,'%')) or " +
            "LOWER(u.lastName) LIKE LOWER(CONCAT('%',:name,'%')) ")
    public Page<UserInformation> findByName(@Param("name") String name, Pageable pageable);

}
