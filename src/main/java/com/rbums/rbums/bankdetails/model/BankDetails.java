package com.rbums.rbums.bankdetails.model;

import com.rbums.rbums.userinformation.model.UserInformation;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;

    private String phoneNumber;

    private String accountNumber;

    private String branch;

    private String accountType;

    @ManyToOne
    @JoinColumn(name = "user_information_id")
    private UserInformation userInformation;
}

