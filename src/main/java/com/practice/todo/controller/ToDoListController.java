package com.practice.todo.controller;


import com.practice.todo.domain.Todo;
import com.practice.todo.domain.User;
import com.practice.todo.dto.LoginInfo;
import com.practice.todo.repository.TodoRepository;
import com.practice.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class ToDoListController {
    private final TodoService todoService;



    @GetMapping("/todo") // 투두리스트
   public String index(Model model , HttpSession session) {
        //데이터베이스에있는 task 값을 select 하여 조회해서 리스트를 뿌려준다.
        User user = new User();

    /* List<Todo> todo = todoService.getTodolist();
     model.addAttribute("task", todo);
        System.out.println(todo);*/
        List<Todo> todo = todoService.getTodolist();
        model.addAttribute("task", todo);

        return "todo";
    }
    @PostMapping("/addtodolist")  //리스트 추가
    public String addlist(  @RequestParam("task") String task,
                            HttpSession session) {

        LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
        if(loginInfo == null){ // 세션에 로그인 정보가 없으면 /loginform으로 redirect
            return "redirect:/";
        }
        // 로그인한 사용자만 글을 써야한다.
        // 세션에서 로그인한 정보를 읽어들인다. 로그인을 하지 않았다면 리스트보기로 자동 이동 시킨다.

        // 로그인 한 회원 정보 + 제목, 내용을 저장한다.System.out.println("content : " + content);

         todoService.addTodo(loginInfo.getUserId(), task);

        return "redirect:/todo"; // 리스트 보기로 리다이렉트한다.
    }


    @PostMapping("/updatetodolist") //리스트 수정
    public String updatelist(){
        return "/";
    }

    @PostMapping("/deletetodolist") //리스트 삭제
     public String deletelist(){
        return "/";
    }






}
