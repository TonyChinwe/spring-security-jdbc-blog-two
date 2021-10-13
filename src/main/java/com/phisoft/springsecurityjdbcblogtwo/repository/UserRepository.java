package com.phisoft.springsecurityjdbcblogtwo.repository;

import com.phisoft.springsecurityjdbcblogtwo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> getUserByUsername(String username);
}
