package com.example.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDetailsManager userDetailsManager;

    public void addNewUser(String username, String password) {
        if (userDetailsManager.userExists(username)) {
            // TODO: throw UserAlreadyExistsException
        } else {
            UserDetails user = createUserDetails(username, password);
            userDetailsManager.createUser(user);
        }
    }

    private UserDetails createUserDetails(String username, String password) {
        return User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("USER")
                .build();
    }

}
