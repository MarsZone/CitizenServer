package com.mars.citizen;

import com.mars.citizen.security.LoginService;
import com.mars.citizen.security.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private LoginService loginService;
    @Bean
    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin").password("{noop}admin").roles("").build());
//        manager.createUser(User.withUsername("guest").password("{noop}guest").roles("").build());
//        return manager;
        return username -> {
            List<UserEntity> users = loginService.getUserByUsername(username);
            if (users == null || users.size() == 0) {
                throw new UsernameNotFoundException("用户名未找到");
            }
            String password = users.get(0).getPassword();
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String passwordAfterEncoder = passwordEncoder.encode(password);
            return User.withUsername(username).password(passwordAfterEncoder).roles("").build();
        };
    }
}
