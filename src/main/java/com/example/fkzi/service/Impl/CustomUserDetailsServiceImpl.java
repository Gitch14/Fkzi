package com.example.fkzi.service.Impl;

import com.example.fkzi.model.user.User;
import com.example.fkzi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = (UserDetails) userRepository.findUserByMailboxAddress(username);
        if (userDetails != null){
            return (UserDetails) userRepository.findUserByMailboxAddress(username);
        }

        userDetails = (UserDetails) userRepository.findByFullName(username);
        if (userDetails != null){
            return (UserDetails) userRepository.findByFullName(username);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
