package com.example.newdemo.security;

import com.example.newdemo.entity.User;
import com.example.newdemo.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserServiceDetails implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserServiceDetails(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findFirstByUsername(username);
        if(user != null) {
            return new CustomUserDetails(
                    user.getUserId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getAddress(),
                    user.getUsername(),
                    user.getPassword(),
                    user.isEnabled(),
                    user.getAuthorities(),
                    user.getReservations()

            );

        }else{
            throw new UsernameNotFoundException("User Not Found.");

        }


    }





}//class

