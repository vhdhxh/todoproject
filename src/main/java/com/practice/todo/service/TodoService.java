package com.practice.todo.service;


import com.practice.todo.dao.TodoDao;
import com.practice.todo.dto.TodoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TodoService {

    @Autowired
    private final TodoDao tododao;

  //  @Transactional
 //   public TodoDto getlist(String task, Date regDate , String taskId) {
    //    TodoDto todo = tododao.getlist(task, regDate, taskId);


    }

