package com.example.newdemo.service;

import com.example.newdemo.entity.Authority;
import com.example.newdemo.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService{
    private final AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Optional<Authority> findById(int id) {
        return authorityRepository.findById(id);
    }

    @Override
    public Authority findByAuthorityName(String authorityName) {
        return authorityRepository.findByAuthorityName(authorityName);
    }

    @Override
    public void saveAuthority(Authority authority) {
        authorityRepository.save(authority);
    }
}
