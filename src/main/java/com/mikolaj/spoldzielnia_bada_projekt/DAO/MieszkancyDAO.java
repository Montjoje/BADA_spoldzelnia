package com.mikolaj.spoldzielnia_bada_projekt.DAO;

import com.mikolaj.spoldzielnia_bada_projekt.tables.Mieszkancy;
import com.mikolaj.spoldzielnia_bada_projekt.tables.SpoldzielnieMieszkaniowe;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MieszkancyDAO {

    private final JdbcTemplate jdbcTemplate;

    public MieszkancyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mieszkancy> list() {
        String sql = "SELECT * FROM mieszkancy";
        return jdbcTemplate.query(
                sql,
                BeanPropertyRowMapper.newInstance(Mieszkancy.class)
        );
    }

    public Mieszkancy getMieszkancy(int nrMieszkanca) {
        return null;
    }

    public void save(Mieszkancy m) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("mieszkancy")
                .usingColumns(
                        "imie_mieszkanca",
                        "nazwisko_mieszkanca",
                        "pesel",
                        "wiek",
                        "stan_cywilny",
                        "plec",
                        "numer_kontaktowy",
                        "nr_lokalu",
                        "password"
                );

        BeanPropertySqlParameterSource param =
                new BeanPropertySqlParameterSource(m);

        insert.execute(param);
    }

    public void update(Mieszkancy m) {
        String sql = "UPDATE mieszkancy SET " +
                "imie_mieszkanca = ?, " +
                "nazwisko_mieszkanca = ?, " +
                "pesel = ?, " +
                "wiek = ?, " +
                "stan_cywilny = ?, " +
                "plec = ?, " +
                "numer_kontaktowy = ?, " +
                "nr_lokalu = ? " +
                "WHERE nr_mieszkanca = ?";

        jdbcTemplate.update(
                sql,
                m.getImieMieszkanca(),
                m.getNazwiskoMieszkanca(),
                m.getPesel(),
                m.getWiek(),
                m.getStanCywilny(),
                m.getPlec(),
                m.getNumerKontaktowy(),
                m.getNrLokalu(),
                m.getNrMieszkanca()
        );
    }

    public void delete(int nrMieszkanca) {
        String sql = "DELETE FROM mieszkancy WHERE nr_mieszkanca = ?";
        jdbcTemplate.update(sql, nrMieszkanca);
    }
}
