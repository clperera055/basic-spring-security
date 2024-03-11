package com.springsecurity.BankingSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true, securedEnabled = true
)
public class BankSystemSecurityConfig {

    @Bean
    SecurityFilterChain chain (HttpSecurity security)throws Exception{
        security.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/notices/notice-details", "/api/v1/sign-up/register").permitAll()
                .antMatchers("/api/v1/employee/employee-details").hasAnyRole("EMPLOYEE", "ADMIN")
                .antMatchers("/api/v1/account/account-details").hasAnyRole("ACCOUNTANT", "ADMIN")
                .and().formLogin().and().httpBasic();
        return security.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
