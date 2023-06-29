package com.practice.todo.service;


import com.practice.todo.domain.Todo;
import com.practice.todo.domain.User;
import com.practice.todo.dto.LoginInfo;
import com.practice.todo.repository.TodoRepository;
import com.practice.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Autowired
    private final HttpSession session;



    @Transactional
    public void addTodo(int userId, String task) {
        User user = userRepository.findById(userId).orElseThrow();
        Todo todo = new Todo();
        todo.setRegDate(LocalDateTime.now());
        todo.setTask(task);
        todo.setUser(user);
        todoRepository.save(todo);
    }

    @Transactional
    public List<Todo> getTodolist(){
        LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
        int UserId= loginInfo.getUserId();
        User user = new User();
        user.setUserId(UserId);
     /* List<Todo> todo = todoRepository.findAll();*/
        List<Todo> todo = todoRepository.findByUser(user);

      return todo;
//        Todo.getUser(); // lazy loading


    }

    @Transactional
    public void deleteTodo(int userId, int taskId) {
        Todo todo = todoRepository.findById(taskId).orElseThrow();
        if (todo.getUser().getUserId() == userId) {
            todoRepository.delete(todo);
        }
    }

    @Transactional
    public void deleteTodo(int taskId) {
        todoRepository.deleteBytaskId(taskId);
    }

    @Transactional
    public void updateTodo(int TodoId, String task) {
        Todo todo = todoRepository.findById(TodoId).orElseThrow();
        todo.setTask(task);
    }
}








