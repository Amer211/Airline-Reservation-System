package com.example.newdemo.service;

import com.example.newdemo.entity.Authority;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuthorityService {
    Optional<Authority> findById(int id);
    Authority findByAuthorityName(String authorityName);

    void saveAuthority(Authority authority);

}
