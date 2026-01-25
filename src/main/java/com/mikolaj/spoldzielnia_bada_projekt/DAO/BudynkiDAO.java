package com.mikolaj.spoldzielnia_bada_projekt.DAO;

import com.mikolaj.spoldzielnia_bada_projekt.tables.Budynki;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BudynkiDAO {



    private final JdbcTemplate jdbcTemplate;

    public BudynkiDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Budynki> list() {
        String sql = "SELECT b.nr_budynku, b.liczba_pieter, b.nr_spoldzielni, " +
                "b.nr_adresu AS numer_adresu, a.miasto, a.ulica, a.numer_budynku, " +
                "a.numer_lokalu, a.kod_pocztowy " +
                "FROM budynki b " +
                "INNER JOIN adresy a ON b.nr_adresu = a.numer_adresu";
        List<Budynki> BudynkiList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Budynki.class));
        return BudynkiList;
    }
    public Budynki getBudynki(int nrBudynku){
        return null;
    }

    public void save(Budynki budynki) {
        budynki.setNumerAdresu(jdbcTemplate.queryForObject("SELECT adresy_sequence.NEXTVAL FROM dual", Long.class));
        SimpleJdbcInsert insertActorAdresy = new SimpleJdbcInsert(jdbcTemplate);
        insertActorAdresy.withTableName("adresy").usingColumns( "numer_adresu", "miasto", "ulica", "numer_budynku", "numer_lokalu", "kod_pocztowy");
        BeanPropertySqlParameterSource paramAdresy = new BeanPropertySqlParameterSource(budynki);
        insertActorAdresy.execute(paramAdresy);
        String insertBudynek = "INSERT INTO budynki (liczba_pieter, nr_spoldzielni, nr_adresu) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                insertBudynek,
                budynki.getLiczbaPieter(),
                budynki.getNrSpoldzielni(),
                budynki.getNumerAdresu()
        );

    }


    public void update(Budynki b) {
        String sql = "UPDATE budynki SET " + "liczba_pieter = ?, " + "nr_spoldzielni = ?, " + "nr_adresu = ?" + " WHERE nr_budynku = ?";

        jdbcTemplate.update(sql, b.getLiczbaPieter(), b.getNrSpoldzielni(), b.getNumerAdresu(), b.getNrBudynku());

        String sqla = "UPDATE adresy SET " + "miasto = ?, " + "ulica = ?, " + "numer_budynku = ?, " + "numer_lokalu = ?, " + "kod_pocztowy = ? " + " WHERE numer_adresu = ?";

        jdbcTemplate.update(sqla, b.getMiasto(), b.getUlica(), b.getNumerBudynku(), b.getNumerLokalu(), b.getKodPocztowy(), b.getNumerAdresu());

    }

    public void delete(int nrBudynku) {
        String search = "SELECT nr_adresu FROM budynki WHERE nr_budynku = ?";
        int numerAdresu = jdbcTemplate.queryForObject(search, Integer.class, nrBudynku);
        String sqla = "DELETE FROM adresy WHERE numer_adresu = ?";
        String sql = "DELETE FROM budynki WHERE nr_budynku = ?";
        jdbcTemplate.update(sql, nrBudynku);
        jdbcTemplate.update(sqla, numerAdresu);

    }
}
