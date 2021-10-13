package com.phisoft.springsecurityjdbcblogtwo.service;

import com.phisoft.springsecurityjdbcblogtwo.entities.User;
import com.phisoft.springsecurityjdbcblogtwo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public Optional<User> getUserByUserName(String username){
        return userRepository.getUserByUsername(username);
    }

    public boolean registerUser(User user){
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     User savedUser= userRepository.save(user);
     return savedUser !=null;

    }

}
