package com.practice.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String UserId;
    private int password;
    private String email;
}
