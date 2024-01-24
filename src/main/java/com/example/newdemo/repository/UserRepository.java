package com.example.newdemo.repository;

import com.example.newdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User findFirstByUsername(String username);

    boolean existsByUsername(String username);
}
