package com.gy.repository;

import com.gy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
