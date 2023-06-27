package com.practice.todo.service;

import com.practice.todo.domain.User;
import com.practice.todo.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
     private final UserRepository userRepository;

     @Transactional
     public User addUser(String name, String email, String password){
          // 트랜잭션이 시작된다.
          Optional<User> optionalUser = userRepository.findByEmail(email);
          if (optionalUser.isPresent()) {
               throw new RuntimeException("이미 가입된 이메일입니다.");
          }


          User user = new User();
          user.setPassword(password);
          user.setEmail(email);
          user.setName(name);
          user = userRepository.save(user);
          return user;
          // 트랜잭션이 끝난다.
     }

     @Transactional
     public User getUser(String email){
          return userRepository.findByEmail(email).orElseThrow();
     }



}
