package ca.sheridancollege.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    public List<String> getAuthorities(){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "SELECT DISTINCT authority FROM authorities";

        List<String> authorities = jdbc.queryForList(query, namedParameters, String.class);

        return authorities;
    }
}
