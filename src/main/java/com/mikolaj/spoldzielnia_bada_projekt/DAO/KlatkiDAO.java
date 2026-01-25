package com.mikolaj.spoldzielnia_bada_projekt.DAO;

import com.mikolaj.spoldzielnia_bada_projekt.tables.Klatki;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class KlatkiDAO {

    private final JdbcTemplate jdbcTemplate;

    public KlatkiDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klatki> list() {
        String sql = "SELECT * FROM klatki";
        List<Klatki> KlatkiList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klatki.class));
        return KlatkiList;
    }
    public Klatki getKlatki(int nrKlatki){
        return null;
    }

    public void save(Klatki klatki) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klatki").usingColumns("numer_w_budynku", "liczba_wind", "nr_budynku");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klatki);
        insertActor.execute(param);


    }


    public void update(Klatki k) {
        String sql = "UPDATE klatki SET " + "numer_w_budynku = ?, " + "liczba_wind = ?, " + "nr_budynku = ?" + " WHERE nr_klatki = ?";

        jdbcTemplate.update(sql, k.getNumerWBudynku(), k.getLiczbaWind(), k.getNrBudynku(), k.getNrKlatki());

    }

    public void delete(int nrKlatki) {
        String sql = "DELETE FROM klatki WHERE nr_klatki = ?";
        jdbcTemplate.update(sql, nrKlatki);


    }
}

