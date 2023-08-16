package com.example.fkzi.repository;

import com.example.fkzi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByMailboxAddress(String email);
    User findByFullName(String fullName);
}