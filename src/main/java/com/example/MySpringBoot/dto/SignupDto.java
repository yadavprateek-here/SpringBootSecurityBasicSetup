package com.example.MySpringBoot.dto;

import lombok.Data;
import lombok.ToString;

@ToString
public class SignupDto {
    private String username;
    private String password;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SignupDto(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
    public SignupDto() {}

    @Override
    public String toString() {
        return "SignupDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
