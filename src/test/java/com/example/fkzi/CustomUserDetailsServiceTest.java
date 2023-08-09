package com.example.fkzi;

import com.example.fkzi.model.enumP.Role;
import com.example.fkzi.model.user.User;
import com.example.fkzi.repository.UserRepository;
import com.example.fkzi.service.Impl.CustomUserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsServiceImpl userDetailsService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testLoadUserByUsername_UserFound_ReturnsUserDetails1() {
        String username = "root";
        String password = "root";
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setMailboxAddress(username);
        user.setUserPassword(encodedPassword);
        user.setJobTitle(String.valueOf(Role.ROLE_ADMIN));

        when(userRepository.findUserByMailboxAddress(username)).thenReturn(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        assertEquals(username, userDetails.getUsername());
        assertEquals(encodedPassword, userDetails.getPassword());
        assertEquals(Collections.singleton(Role.ROLE_ADMIN), userDetails.getAuthorities());

        verify(userRepository, times(1)).findUserByMailboxAddress(username);
    }

    @Test
    void testLoadUserByUsername_UserFound_ReturnsUserDetails2() {
        // Given
        User user = new User();
        user.setFullName("root");
        user.setMailboxAddress("root@gmail.com");
        user.setUserPassword(passwordEncoder.encode("root")); // Encode the password
        user.setJobTitle("ROLE_ADMIN"); // Assuming your role naming is like this
        user.setActive(true);
        user.setAdmin(false);
        userRepository.save(user);

        // When
        UserDetails userDetails = userDetailsService.loadUserByUsername("root");

        // Then
       // assertNotNull(userDetails);
        assertEquals("root", userDetails.getUsername());
        assertTrue(userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER")));
        assertTrue(userDetails.isEnabled());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound_ThrowsUsernameNotFoundException() {
        String username = "root";

        when(userRepository.findUserByMailboxAddress(username)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(username));

        verify(userRepository, times(1)).findUserByMailboxAddress(username);
    }
}
