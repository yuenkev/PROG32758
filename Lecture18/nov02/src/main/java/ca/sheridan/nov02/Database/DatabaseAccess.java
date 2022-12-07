package ca.sheridan.nov02.Database;

import ca.sheridan.nov02.beans.Bob;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
@AllArgsConstructor
public class DatabaseAccess {

    private NamedParameterJdbcTemplate jdbc;

    public List<Bob> getUsers(){
        // helper class for jdbc
        MapSqlParameterSource mapper = new MapSqlParameterSource();

        //query
        String query = "SELECT * FROM users";

        //helper class converts rows from dbas to objects
        BeanPropertyRowMapper<Bob> rower = new BeanPropertyRowMapper<>(Bob.class);

        //excute w/jdbc
        List<Bob> bobs = jdbc.query(query, mapper, rower);

        return bobs;
    }


    public Long addUser(Bob user){

        MapSqlParameterSource mapper = new MapSqlParameterSource();

        String query = "INSERT INTO users (name, email, address) VALUES (:name, :email, :address)";


        mapper
                .addValue("name", user.getName())
                .addValue("email", user.getEmail())
                .addValue("address", user.getAddress());

    //    KeyHolder generatedKEy = new GeneratedKeyHolder();
        int returnValue = jdbc.update(query, mapper);

        Long.valueOf(returnValue++);

     //   Long studentId = (Long) generatedKEy.getKey();

        return  Long.valueOf(returnValue++);

    }
}
