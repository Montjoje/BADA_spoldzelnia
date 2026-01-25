package com.mikolaj.spoldzielnia_bada_projekt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final MyUserDetailService myUserDetailService;
    private final BCryptPasswordEncoder passwordEncoder;

    public WebSecurityConfig(MyUserDetailService myUserDetailService, BCryptPasswordEncoder passwordEncoder) {
        this.myUserDetailService = myUserDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/index").permitAll()
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/perspectives", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/index")
                        .permitAll()
                );
        return http.build();
    }
    /**
     * Configures the UserDetailsService.
     *
     * @return the configured UserDetailsService
     */
    @Bean
    public UserDetailsService userDetailService() {
        return myUserDetailService;
    }

    /**
     * Configures the AuthenticationProvider.
     *
     * @return the configured AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(myUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    /**
     * Configures the password encoder.
     *
     * @return the configured BCryptPasswordEncoder
     */

/*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

  / @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("user1"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("user2"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }*/
}

