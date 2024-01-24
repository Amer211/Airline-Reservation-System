package com.example.newdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserServiceDetails userServiceDetails;
    private final CustomLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    public SecurityConfig(CustomUserServiceDetails userServiceDetails, CustomLogoutSuccessHandler logoutSuccessHandler) {
        this.userServiceDetails = userServiceDetails;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userServiceDetails)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(config->config
                        .requestMatchers("/","/Home","/register/**"
                                ,"/login**","/search","/showFlights","/findFlight"
                                ,"/bookFlight","/submitBooking","/searchReservation/**"
                                ,"/findReservation","/cancelReservation")
                        .permitAll()
                        .anyRequest().authenticated()


                )

                .formLogin(form->form
                        .loginPage("/login")
                        .usernameParameter("username")
                        .defaultSuccessUrl("/account")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error=true ")
                        .permitAll()
                )
//                .rememberMe(remember->
//                        remember
//                                .key("key")
//                                .tokenValiditySeconds(300)
//                                .userDetailsService(userServiceDetails)
//                                .rememberMeParameter("remember me")
//                                .rememberMeCookieName("remember-me-cookie")

 //               )
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .logoutSuccessUrl("/Home")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                );
        return http.build();


    }














}//class
