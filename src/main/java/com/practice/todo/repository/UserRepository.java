package com.practice.todo.repository;

import com.practice.todo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//Spring Data JPA Repository
//Spring JDBC 의 DAO와 유사한 기능.
//Spring Data JPA는 UserRepository 를 구현하는 Bean을 자동 생성해준다. 때문에 구현체를 만들지 않아도 OK
public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByEmail(String email);

    // where name = ? and email = ?
    Optional<User> findByNameAndEmail(String name, String email);

    // where name = ? or email = ?
    List<User> findByNameOrEmail(String name, String email);

    // where user_id between ? and ?
    List<User> findByUserIdBetween(int startUserId, int endUserId);

    // where user_id < ?
    List<User> findByUserIdLessThan(int userId);

    // where user_id <= ?
    List<User> findByUserIdLessThanEqual(int userId);

    // where user_id > ?
    List<User> findByUserIdGreaterThan(int userId);

    // where user_id >= ?
    List<User> findByUserIdGreaterThanEqual(int userId);

    // where regdate > ?
    List<User> findByRegdateAfter(LocalDateTime day);

    // where regdate < ?
    List<User> findByRegdateBefore(LocalDateTime day);

    // where name is null
    List<User> findByNameIsNull();

    // where name is not null
    List<User> findByNameIsNotNull();

    // where name like ?
    List<User> findByNameLike(String name);

    // where name like '입력한값%'
    List<User> findByNameStartingWith(String name);

    // where name like '%입력한값'
    List<User> findByNameEndingWith(String name);

    // where name like '%입력한값%'
    List<User> findByNameContaining(String name);

    // order by name asc
    List<User> findByOrderByNameAsc();

    // order by name desc
    List<User> findByOrderByNameDesc();

    // where regdate > ? order by name desc
    List<User> findByRegdateAfterOrderByNameDesc(LocalDateTime day);

    // where name = ?
    List<User> findByName(String name);

    // where name <> ?
    List<User> findByNameNot(String name);

    // where user_id in ( ...... )
    List<User> findByUserIdIn(Collection<Integer> userIds);

    // where user_id not in ( .... )
    List<User> findByUserIdNotIn(Collection<Integer> userIds);

    // select count(*) from user3
    Long countBy();

    // select count(*) from user3 where name like ?
    Long countByNameLike(String name);

    // where email = ?
    boolean existsByEmail(String email);

    // select * from user3 where name = ?
    // select한 건수만큼 delete from user3 where user_id = ?
    int deleteByName(String name);

    // select distinct * from user3 where name = ?
    List<User> findNameDistinctByName(String name);

    // select * from user3 limit 2
    List<User> findFirst2By();
    List<User> findTop2By();

    Page<User> findByName(String name, Pageable pageable);
}

