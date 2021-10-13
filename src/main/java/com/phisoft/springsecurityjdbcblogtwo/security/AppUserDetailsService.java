package com.phisoft.springsecurityjdbcblogtwo.security;

import com.phisoft.springsecurityjdbcblogtwo.entities.User;
import com.phisoft.springsecurityjdbcblogtwo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser =userService.getUserByUserName(username);
        User user=optionalUser.orElseThrow(()->new UsernameNotFoundException("User is not found"));
        return new AuthUser(user);
    }
}
