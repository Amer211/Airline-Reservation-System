package com.example.newdemo.service;

import com.example.newdemo.entity.Authority;
import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.User;
import com.example.newdemo.repository.AuthorityRepository;
import com.example.newdemo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
    private final ReservationService reservationService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, ReservationService reservationService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.reservationService = reservationService;
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {

        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Authority authority = authorityRepository.findById(3).orElse(null);
        if(user.getAuthorities()==null){
            user.setAuthorities(new ArrayList<>());
        }
        user.getAuthorities().add(authority);

        userRepository.save(user);

        System.out.println(user.getUsername()+" was saved.");
    }

    // **********************create Admin******************************
    @Override
    public void addAdmin(String username) {
        if(!userRepository.existsByUsername(username)) {
            User user = new User();
            user.setEnabled(true);
            user.setUsername("Admin");//change it
            user.setPassword(passwordEncoder.encode("admin"));//change it
            Authority authority = authorityRepository.findById(1).orElse(null);//1 for ADMIN
            if (user.getAuthorities() == null) {
                user.setAuthorities(new ArrayList<>());
            }
            user.getAuthorities().add(authority);
            user.setAddress("Admin");
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setEmail("Admin@admin.com");
            user.setPhoneNumber("1111111111");

            userRepository.save(user);

            System.out.println(user.getUsername() + " was saved as an ADMIN.");

        }else {
            System.out.println("Admin Already exist!");
        }



    }

    @Override
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // *********************Add and save a manager******************************
    @Override
    public void saveManager(User user) {
        if(!userRepository.existsByUsername(user.getUsername())){
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Authority authority = authorityRepository.findById(2).orElse(null);
            if(user.getAuthorities()==null){
                user.setAuthorities(new ArrayList<>());
            }
            user.getAuthorities().add(authority);

            userRepository.save(user);

            System.out.println(user.getUsername()+" was saved as a Manager.");
        }else {
            System.out.println("Manager Already exists!");
        }

    }

    @Override
    public List<Reservation> getReservationsByUsername(String username) {
        User user= userRepository.findByUsername(username);
        if(user!=null){
            return user.getReservations();
        }
        return new ArrayList<>();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(String reservationId) {
        System.out.println("reservation ID :"+ reservationId);
        return reservationService.findReservationById(reservationId);

    }


}
