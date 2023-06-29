package com.practice.todo.repository;

import com.practice.todo.domain.Todo;
import com.practice.todo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo , Integer> {
    // JPQL 을 사용할 수 있다.
    // JPQL 은 SQL과 모양이 비슷하지만, SQL이 아니다.
    // JPQL 은 객체지향 언어이다.
    // JPQL에서 from 뒤에 있는 것은 엔티티 이름.
    // Board 엔티티들을 조회하라. 엔티티는 결국 table과 관계.
  /* @Query(value = "select t, u from todolist t join User u on t.userId = u.userId")
    List<Todo> getTodolist();*/

    List<Todo> findByUser(User UserId);
    List <Todo> findAll();

    List <Todo> deleteBytaskId(int taskId);



}


