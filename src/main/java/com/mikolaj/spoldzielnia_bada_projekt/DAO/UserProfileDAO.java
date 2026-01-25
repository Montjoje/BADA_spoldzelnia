package com.mikolaj.spoldzielnia_bada_projekt.DAO;

import com.mikolaj.spoldzielnia_bada_projekt.tables.UserProfileDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDAO {
    private final JdbcTemplate jdbcTemplate;

    public UserProfileDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserProfileDTO getProfile(int nrMieszkanca) {

        String sql = "SELECT\n" +
                "  m.imie_mieszkanca     AS imieMieszkanca,\n" +
                "  m.nazwisko_mieszkanca AS nazwiskoMieszkanca,\n" +
                "  m.pesel,\n" +
                "  m.wiek,\n" +
                "  m.stan_cywilny        AS stanCywilny,\n" +
                "  m.plec,\n" +
                "  m.numer_kontaktowy    AS numerKontaktowy,\n" +
                "\n" +
                "  l.numer_w_budynku     AS numerWBudynku,\n" +
                "  l.metraz,\n" +
                "  l.liczba_pokoi        AS liczbaPokoi,\n" +
                "  l.nr_pietra           AS nrPietra,\n" +
                "\n" +
                "  e.adres_email         AS adresEmail\n" +
                "FROM mieszkancy m\n" +
                "JOIN lokale l\n" +
                "  ON m.nr_lokalu = l.nr_lokalu\n" +
                "LEFT JOIN adresy_email e\n" +
                "  ON e.nr_mieszkanca = m.nr_mieszkanca " +
                "WHERE m.nr_mieszkanca = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            UserProfileDTO dto = new UserProfileDTO();

            dto.setImieMieszkanca(rs.getString("imieMieszkanca"));
            dto.setNazwiskoMieszkanca(rs.getString("nazwiskoMieszkanca"));

            dto.setPesel(rs.getString("pesel"));
            dto.setWiek(rs.getObject("wiek", Integer.class));
            dto.setStanCywilny(rs.getString("stanCywilny"));

            String plec = rs.getString("plec");
            dto.setPlec(plec != null ? plec.charAt(0) : null);

            dto.setNumerKontaktowy(rs.getString("numerKontaktowy"));

            dto.setNumerWBudynku(rs.getObject("numerWBudynku", Integer.class));
            dto.setMetraz(rs.getObject("metraz", Double.class));
            dto.setLiczbaPokoi(rs.getObject("liczbaPokoi", Integer.class));
            dto.setNrPietra(rs.getObject("nrPietra", Integer.class));

            dto.setAdresEmail(rs.getString("adresEmail"));

            return dto;
        }, nrMieszkanca);
    }
    public void updatePhoneAndEmail(
            int nrMieszkanca,
            String numerKontaktowy,
            String adresEmail
    ) {

        String updatePhoneSql = """
            UPDATE mieszkancy
            SET numer_kontaktowy = ?
            WHERE nr_mieszkanca = ?
        """;

        jdbcTemplate.update(updatePhoneSql, numerKontaktowy, nrMieszkanca);

        // 2️⃣ update emaila (dopasuj SQL do swojej relacji!)
        String mergeEmailSql = """
            MERGE INTO adresy_email e
            USING (SELECT ? AS nr_mieszkanca, ? AS adres_email FROM dual) src
            ON (e.nr_mieszkanca = src.nr_mieszkanca)
            WHEN MATCHED THEN
              UPDATE SET e.adres_email = src.adres_email
            WHEN NOT MATCHED THEN
              INSERT (nr_mieszkanca, adres_email)
              VALUES (src.nr_mieszkanca, src.adres_email)
        """;

        jdbcTemplate.update(mergeEmailSql, nrMieszkanca, adresEmail);
    }

}
