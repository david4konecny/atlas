package com.example.atlas.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    @NotNull @NotBlank(message = "Username is required")
    @Size(min = 3, max = 15, message = "Minimum username length: 3")
    private String username;
    @NotNull @NotBlank(message = "Password is required")
    @Size(min = 4, max = 30, message = "Minimum password length: 4")
    private String password;

    public UserDto() {
    }

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
