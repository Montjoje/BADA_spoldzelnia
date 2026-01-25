package com.mikolaj.spoldzielnia_bada_projekt.DAO;

import com.mikolaj.spoldzielnia_bada_projekt.tables.Lokale;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LokaleDAO {

    private final JdbcTemplate jdbcTemplate;

    public LokaleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Lokale> list() {
        String sql = "SELECT * FROM lokale";
        List<Lokale> LokaleList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lokale.class));
        return LokaleList;
    }
    public Lokale getLokale(int nrLokalu){
        return null;
    }

    public void save(Lokale lokale) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("lokale").usingColumns("numer_w_budynku", "metraz", "liczba_pokoi", "nr_pietra", "nr_klatki");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(lokale);
        insertActor.execute(param);


    }


    public void update(Lokale l) {
        String sql = "UPDATE lokale SET " + "numer_w_budynku = ?, " + "metraz = ?, " + "liczba_pokoi = ?, "   + "nr_pietra= ?, " + "nr_klatki = ?" + " WHERE nr_lokalu = ?";

        jdbcTemplate.update(sql, l.getNumerWBudynku(), l.getMetraz(), l.getLiczbaPokoi(), l.getNrPietra(), l.getNrKlatki(), l.getNrLokalu());

    }

    public void delete(int nrLokalu) {
        String sql = "DELETE FROM lokale WHERE nr_lokalu = ?";
        jdbcTemplate.update(sql, nrLokalu);


    }
}