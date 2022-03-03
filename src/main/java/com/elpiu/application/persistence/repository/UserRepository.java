package com.elpiu.application.persistence.repository;

import com.elpiu.application.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Override
    Optional<User> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Query("select u from User u where u.username = ?1")
    Optional<User> findByUsername(String username);

    @Query("select (count(u) > 0) from User u where u.username = ?1")
    boolean existsByUsername(String username);

    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    @Query("select (count(u) > 0) from User u where u.email = ?1")
    boolean existsByEmail(String email);

    @Override
    List<User> findAll();

    long deleteByUsername(String username);




}

