package com.example.msuser.dao.repository;

import com.example.msuser.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> getUserByUsername(String username);
}
