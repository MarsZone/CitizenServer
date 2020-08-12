package com.mars.citizen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final LoginDao loginDao;
    @Autowired
    public LoginService(LoginDao loginDao){
        this.loginDao = loginDao;
    }
    public List<UserEntity> getUserByUsername(String username){
        return loginDao.getUserByUserName(username);
    }
}
