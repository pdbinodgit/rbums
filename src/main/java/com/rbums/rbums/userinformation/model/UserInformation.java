package com.rbums.rbums.userinformation.model;

import com.rbums.rbums.address.model.Address;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data

public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  firstName;

    private String middleName;

    private String lastName;

    private Long age;

    private LocalDate dateOfBirth;

    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

}
