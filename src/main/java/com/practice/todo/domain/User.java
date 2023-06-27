package com.practice.todo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity //Database Table과 맵핑하는 객체
@Table(name = "user") //Database 테이블 이름 user3 와 User라는 객체가 맵핑.
@NoArgsConstructor //기본생성자 필요
@Getter
@Setter
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // userId는 자동으로 생성되도록 한다. 1,2,3,4
    private Integer userId;

    @Column(length = 50)
    private String name;

    @Column(length = 500)
    private String password;

    @Column(length = 255)
    private String email;

    @CreationTimestamp //현재시간이 저장될때 자동으로 생성.
    private LocalDateTime regdate;
}
