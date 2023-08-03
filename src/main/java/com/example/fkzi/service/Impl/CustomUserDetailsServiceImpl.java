package com.example.fkzi.service.Impl;

import com.example.fkzi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

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
