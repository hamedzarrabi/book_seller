package com.hami.bookseller.security;

import com.hami.bookseller.model.User;
import com.hami.bookseller.service.IUserService;
import com.hami.bookseller.util.SecurityUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

public class CustomeUserDeatilsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userService.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authorities = Set.of(SecurityUnits.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .userName(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
