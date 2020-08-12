package com.mars.citizen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoginDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<UserEntity> getUserByUserName(String username){
        String sql = "select id, username, password from user where username = ?";
        return jdbcTemplate.query(sql,new String[]{username}, new BeanPropertyRowMapper<>(UserEntity.class));
    }
}
