package com.example.fkzi.service;

import com.example.fkzi.model.User;
import com.example.fkzi.model.dto.UserResponse;

public interface UserResponseHandler {
    public UserResponse handleUserResponse(User user);
}
