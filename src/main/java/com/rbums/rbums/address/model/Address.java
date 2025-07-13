package com.rbums.rbums.address.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String district;

    private String municipality;

    private long wardNo;

    private String country;

}
