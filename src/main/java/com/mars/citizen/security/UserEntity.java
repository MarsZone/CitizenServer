package com.mars.citizen.security;

import lombok.Data;

@Data
public class UserEntity {
    private int id;
    private String username;
    private String password;
}
