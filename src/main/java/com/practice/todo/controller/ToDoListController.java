package com.practice.todo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ToDoListController {

    private List<String> tasks = new ArrayList<>();

    @GetMapping("/fdsa")
   public String index(Model model) {
        //데이터베이스에있는 task 값을 select 하여 조회해서 리스트를 뿌려준다.
        model.addAttribute("tasks", tasks);
        System.out.println(tasks);

        return "index";
    }
    @PostMapping("/asdf")
    public String addlist(@RequestParam("task") String task, Model model) {
        //task로 입력받은 값을 데이터에 insert 한다.
       // model.addAttribute("task",task);
        tasks.add(task);

        return "redirect:/";
    }





}
