package ca.sheridancollege.h2database.database;

import ca.sheridancollege.h2database.beans.Avenger;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.spec.NamedParameterSpec;
import java.util.List;

@Repository
@NoArgsConstructor
public class DatabaseAccess {

    private NamedParameterJdbcTemplate jdbc;

    private DatabaseAccess(NamedParameterJdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Avenger> getAvengers() {

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM avengers";


        BeanPropertyRowMapper<Avenger> avengerMapper = new BeanPropertyRowMapper<Avenger>(Avenger.class);

        List<Avenger> avengers = jdbc.query(query, namedParameters, avengerMapper);

        return avengers;
    }
}
