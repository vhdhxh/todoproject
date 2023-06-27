package com.practice.todo;

import com.practice.todo.repository.TodoRepository;
import com.practice.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.practice.todo.domain.User;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

//	@Autowired
//	UserRepository userRepository; // UserRepository를 구현하고있는 Bean을 자동으로 주입(Inject)

//	@Autowired
//	TodoRepository todoRepository;

//	@Override
//	@Transactional    //메소드가 시작할때 트랜젝션이 실행되고, 메소드가 종료될때 트랜잭션이 commit 중간에 Runtimeexception이 발생하면 rollback됨. 이 어노테이션을 사용하면 트랜젝션 코드를 생략해도 된다.
//	public void run(String... args) throws Exception {
		//User user = userRepository.findById(2).orElseThrow(); //UserId 2번에 해당하는것을 조회해라 //Java Optional 이라고 불리는 문법. optional이라는 객체를 리턴하기 때문에 2번에 해당되는 값이 없으면 exception 발생, 있을경우 user을 리턴
       /* User user = new User();             //insert 작업
		user.setName("둘리3");
		user.setEmail("d3@example.com");
		user.setPassword("1234");
		user.setRegdate(LocalDateTime.now());

		userRepository.save(user);*/

		//delete 작업
		//userRepository.deleteById(2);  //UserId가 2인줄을 삭제한다.
		//delete 방법2
	//	User user = userRepository.findById(14).orElseThrow(); //조회한 엔티티를 메소드에 넣어서 삭제하는 방법. (조회 후 삭제)
	//	userRepository.delete(user);

		//update
	//	User user = userRepository.findById(15).orElseThrow();
	//	user.setPassword("5678");
	}

