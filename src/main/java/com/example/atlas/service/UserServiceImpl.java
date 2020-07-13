package com.example.atlas.service;

import com.example.atlas.exception.UserAlreadyExistsException;
import com.example.atlas.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired UserDetailsManager userDetailsManager;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired PracticeRepository practiceRepository;

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

    @Transactional
    public void deleteUser(String username) {
        practiceRepository.deleteByUsername(username);
        userDetailsManager.deleteUser(username);
    }

}
