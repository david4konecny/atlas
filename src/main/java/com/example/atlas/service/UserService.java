package com.example.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserDetailsManager userDetailsManager;
    @Autowired PasswordEncoder passwordEncoder;

    public void addNewUser(String username, String password) throws UserAlreadyExistsException {
        if (userDetailsManager.userExists(username)) {
            throw new UserAlreadyExistsException(username);
        } else {
            UserDetails user = createUserDetails(username, password);
            userDetailsManager.createUser(user);
        }
    }

    private UserDetails createUserDetails(String username, String password) {
        return User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();
    }

    public static class UserAlreadyExistsException extends Throwable {
        public UserAlreadyExistsException(String username) {
            super(String.format("Username %s already exists", username));
        }
    }
}