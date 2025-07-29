package com.rbums.rbums.userinformation.model;

import com.rbums.rbums.address.model.Address;
import com.rbums.rbums.bankdetails.model.BankDetails;
import com.rbums.rbums.role.model.Role;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private LocalDateTime createdAt;

    private String createdBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;
    @OneToMany(mappedBy = "userInformation",cascade = CascadeType.ALL)
    List<BankDetails> bankDetails;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name = "user_roles",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    Set<Role> roles=new HashSet<>();
}
