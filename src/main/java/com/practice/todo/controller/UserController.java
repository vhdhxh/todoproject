package com.practice.todo.controller;

import com.practice.todo.domain.User;
import com.practice.todo.dto.LoginInfo;
import com.practice.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
   private final UserService userService;


    @GetMapping("/")    //로그인 폼
    public String login() {


        return "index";
    }

    @PostMapping("/authenticate")   //로그인
    public String login2(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session){

        try{
            User user = userService.getUser(email);
            if(user.getPassword().equals(password)){
                System.out.println("암호가 같습니다.");
                LoginInfo loginInfo = new LoginInfo(user.getUserId(), user.getEmail(), user.getName());



                session.setAttribute("loginInfo", loginInfo); // 첫번째 파라미터가 key, 두번째 파라미터가 값.
                System.out.println("세션에 로그인 정보가 저장된다.");
            }else{
                throw new RuntimeException("암호가 일치하지 않음.");
            }
        }catch(Exception ex){
            return "redirect:/?error=true";
        }

        return "redirect:/todo";
    }




    @GetMapping("/userReg") //회원가입폼
    public String userReg() {
        return "userReg";
    }

    @PostMapping("/register") //회원가입
    public String register(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam ("password") String password)
                           {
        userService.addUser(name,  email,  password);
        return "redirect:/";
    }


}
