package com.practice.todo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "todolist")
@NoArgsConstructor
@Getter
@Setter
public class Todo {

    @Column(length = 100)
    private String task;


    @CreationTimestamp
    private LocalDateTime regDate;

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public String toString() {
        return "Todo{" +
                "task='" + task + '\'' +
                ", regDate=" + regDate +
                ", taskId=" + taskId +
                '}';
    }
}
