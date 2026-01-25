package com.mikolaj.spoldzielnia_bada_projekt.DAO;

import com.mikolaj.spoldzielnia_bada_projekt.tables.AdresyEmail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyEmailDAO {

    private final JdbcTemplate jdbcTemplate;

    public AdresyEmailDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AdresyEmail> list() {
        String sql = "SELECT * FROM adresy_email";
        List<AdresyEmail> adresyEmailList =
                jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AdresyEmail.class));
        return adresyEmailList;
    }

    public AdresyEmail getAdresyEmail(Integer nrAdrEmail) {
        return null;
    }

    public void save(AdresyEmail adresyEmail) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("adresy_email")
                .usingColumns("adres_email", "nr_pracownika", "nr_mieszkanca");

        BeanPropertySqlParameterSource param =
                new BeanPropertySqlParameterSource(adresyEmail);

        insert.execute(param);
    }

    public void update(AdresyEmail a) {
        String sql = "UPDATE adresy_email SET " +
                "adres_email = ?, " +
                "nr_pracownika = ?, " +
                "nr_mieszkanca = ? " +
                "WHERE nr_adr_email = ?";

        jdbcTemplate.update(
                sql,
                a.getAdresEmail(),
                a.getNrPracownika(),
                a.getNrMieszkanca(),
                a.getNrAdrEmail()
        );
    }

    public void delete(Integer nrAdrEmail) {
        String sql = "DELETE FROM adresy_email WHERE nr_adr_email = ?";
        jdbcTemplate.update(sql, nrAdrEmail);
    }
}

