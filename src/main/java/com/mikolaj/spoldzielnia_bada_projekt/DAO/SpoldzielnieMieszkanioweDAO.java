package com.mikolaj.spoldzielnia_bada_projekt.DAO;

import com.mikolaj.spoldzielnia_bada_projekt.tables.SpoldzielnieMieszkaniowe;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SpoldzielnieMieszkanioweDAO {



    private final JdbcTemplate jdbcTemplate;

    public SpoldzielnieMieszkanioweDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SpoldzielnieMieszkaniowe> list() {
        String sql = "SELECT s.nr_spoldzielni, s.nazwa, s.numer_adresu, a.miasto, a.ulica, a.numer_budynku, a.numer_lokalu, a.kod_pocztowy FROM spoldzielnie_mieszkaniowe s INNER JOIN adresy a ON s.numer_adresu = a.numer_adresu";
        List<SpoldzielnieMieszkaniowe> spoldzielnieMieszkanioweList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(SpoldzielnieMieszkaniowe.class));
        return spoldzielnieMieszkanioweList;
    }
    public SpoldzielnieMieszkaniowe get(int numerSpoldzielni){
        return null;
    }

    public void save(SpoldzielnieMieszkaniowe spoldzielnieMieszkaniowe) {
        spoldzielnieMieszkaniowe.setNumerAdresu(jdbcTemplate.queryForObject("SELECT adresy_sequence.NEXTVAL FROM dual", Long.class));
        SimpleJdbcInsert insertActorAdresy = new SimpleJdbcInsert(jdbcTemplate);
        insertActorAdresy.withTableName("adresy").usingColumns("numer_adresu", "miasto", "ulica", "numer_budynku", "numer_lokalu", "kod_pocztowy");
        BeanPropertySqlParameterSource paramAdresy = new BeanPropertySqlParameterSource(spoldzielnieMieszkaniowe);
        insertActorAdresy.execute(paramAdresy);
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("spoldzielnie_mieszkaniowe").usingColumns("nazwa","numer_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(spoldzielnieMieszkaniowe);
        insertActor.execute(param);

    }


    public void update(SpoldzielnieMieszkaniowe s) {
        String sql = "UPDATE spoldzielnie_mieszkaniowe SET " + "nazwa = ?, " + "numer_adresu = ? " + " WHERE nr_spoldzielni = ?";

        jdbcTemplate.update(sql, s.getNazwa(), s.getNumerAdresu(), s.getNrSpoldzielni());

        String sqla = "UPDATE adresy SET " + "miasto = ?, " + "ulica = ?, " + "numer_budynku = ?, " + "numer_lokalu = ?, " + "kod_pocztowy = ? " + " WHERE numer_adresu = ?";

        jdbcTemplate.update(sqla, s.getMiasto(), s.getUlica(), s.getNumerBudynku(), s.getNumerLokalu(), s.getKodPocztowy(), s.getNumerAdresu());

    }

    public void delete(int nrSpoldzielni) {
        String search = "SELECT numer_adresu FROM spoldzielnie_mieszkaniowe WHERE nr_spoldzielni = ?";
        int numerAdresu = jdbcTemplate.queryForObject(search, Integer.class, nrSpoldzielni);
        String sqla = "DELETE FROM adresy WHERE numer_adresu = ?";
        String sql = "DELETE FROM spoldzielnie_mieszkaniowe WHERE nr_spoldzielni = ?";
        jdbcTemplate.update(sql, nrSpoldzielni);
        jdbcTemplate.update(sqla, numerAdresu);

    }
}