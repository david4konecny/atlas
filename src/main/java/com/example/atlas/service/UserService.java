package com.example.atlas.service;

import com.example.atlas.exception.UserAlreadyExistsException;

public interface UserService {
    void addNewUser(String username, String password) throws UserAlreadyExistsException;
    void deleteUser(String username);
}
