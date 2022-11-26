package com.example.msuser.repository;

import com.example.msuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> getUserByUsername(String username);
}
