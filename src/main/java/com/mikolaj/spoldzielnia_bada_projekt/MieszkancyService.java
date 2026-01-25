package com.mikolaj.spoldzielnia_bada_projekt;

import com.mikolaj.spoldzielnia_bada_projekt.DAO.MieszkancyDAO;
import com.mikolaj.spoldzielnia_bada_projekt.tables.Mieszkancy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MieszkancyService {
    private final MyUserRepository myUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final MieszkancyDAO mieszkancyDAO;

    public MieszkancyService(MyUserRepository myUserRepository,
                             BCryptPasswordEncoder passwordEncoder, MieszkancyDAO mieszkancyDAO) {
        this.myUserRepository = myUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.mieszkancyDAO = mieszkancyDAO;
    }

    public void updatePassword(int nrMieszkanca, String rawPassword) {
        if (rawPassword == null || rawPassword.isBlank()) {
            return;
        }

        String hash = passwordEncoder.encode(rawPassword);
        myUserRepository.updatePassword(nrMieszkanca, hash);
    }

    public void save(Mieszkancy m) {
        m.setPassword(passwordEncoder.encode(m.getPassword()));
        mieszkancyDAO.save(m);
    }
}


