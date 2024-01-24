package com.example.newdemo.repository;

import com.example.newdemo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
    Authority findByAuthorityName(String authorityName);
}
