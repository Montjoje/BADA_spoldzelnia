package com.mikolaj.spoldzielnia_bada_projekt;

import com.mikolaj.spoldzielnia_bada_projekt.tables.Mieszkancy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private final MyUserRepository myUserRepository;



    // Constructor injection for MyUserRepository
    public MyUserDetailService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;

    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("$2a$10$Jg.5pAd827ZW/XDfuCpBf.WJC6NOAuuj4OEb8vr8Y3yDMQXCG5qO.")
                    .roles("ADMIN")
                    .build();
        }


        Mieszkancy user = myUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return User.builder()
                .username("mieszkaniec@" + user.getNrMieszkanca())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }


}
