package com.mikolaj.spoldzielnia_bada_projekt;

import com.mikolaj.spoldzielnia_bada_projekt.tables.Mieszkancy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public MyUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Mieszkancy> findByUsername(String username) {
        String[] parts = username.split("@");
        int nrMieszkanca = Integer.parseInt(parts[1]);

        String sql = "SELECT nr_mieszkanca, password FROM mieszkancy WHERE nr_mieszkanca = ?";

        return jdbcTemplate
                .query(sql,
                        BeanPropertyRowMapper.newInstance(Mieszkancy.class),
                        nrMieszkanca)
                .stream()
                .findFirst();
    }
    public void updatePassword(int nrMieszkanca, String hashedPassword) {
        jdbcTemplate.update(
                "UPDATE mieszkancy SET password = ? WHERE nr_mieszkanca = ?",
                hashedPassword,
                nrMieszkanca
        );
    }
}
