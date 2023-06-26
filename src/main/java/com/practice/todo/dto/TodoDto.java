package com.practice.todo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TodoDto {
    private String task;
    private Date regDate;
    private int taskId;
}
