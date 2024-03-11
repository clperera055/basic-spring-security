package com.springsecurity.BankingSystem.config;

import com.springsecurity.BankingSystem.model.User;
import com.springsecurity.BankingSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserNamePasswordAuthentication implements AuthenticationProvider {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        List<User> userList = userRepo.findByEmail(userName);

        if(userList.size() > 0 && passwordEncoder.matches(pwd, userList.get(0).getPassword())){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(userList.get(0).getRole()));
            return new UsernamePasswordAuthenticationToken(userList,pwd,authorities);
        }
        else
            throw new BadCredentialsException("Invalid username or password.....");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
