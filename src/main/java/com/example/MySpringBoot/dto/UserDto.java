package com.example.MySpringBoot.dto;

import lombok.Data;
import lombok.ToString;


public class UserDto {
    private Long id;
    private String username;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }

    public UserDto() {}

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
