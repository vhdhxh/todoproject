package com.practice.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
//@AllArgsConstructor // 모든 필드에 대한 생성자가 자동으로 만들어진다.
public class LoginInfo {
    private int userId;
    private String email;
    private String name;


    public LoginInfo(int userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }
}
