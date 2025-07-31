package com.smartcare.services;

import com.smartcare.models.User;
import com.smartcare.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

   // In CustomUserDetailsService.java
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("--- USER DETAILS SERVICE: Trying to find user: " + username + " ---");

    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    System.out.println("--- USER DETAILS SERVICE: User found! ---");

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

}