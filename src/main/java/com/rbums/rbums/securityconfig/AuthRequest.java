package com.rbums.rbums.securityconfig;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;

}
