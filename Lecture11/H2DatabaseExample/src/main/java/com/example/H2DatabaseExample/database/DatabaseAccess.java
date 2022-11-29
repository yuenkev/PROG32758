package com.example.H2DatabaseExample.database;

import com.example.H2DatabaseExample.beans.Avenger;
import lombok.NoArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@NoArgsConstructor
public class DatabaseAccess {

    private NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Avenger> getAvengers(){
        try {
            //here we aren't really doing anything with it now
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            String query = "SELECT * FROM avengers";


            //this caused the error due to the constraint
            //        query = "SELECT * FROM avengers WHERE age >:minAge";
            namedParameters.addValue("minAge", 26); //play around with different numbers
            //Will map a row coming in to an instance of Avenger
            BeanPropertyRowMapper<Avenger> avengerMapper = new BeanPropertyRowMapper<Avenger>(Avenger.class);
            //Now that we prepared the helper objects,
            //this one call does it all

            List<Avenger> avengers = jdbc.query(query, namedParameters, avengerMapper);
            return avengers;
        }
        catch (Exception e){
            System.out.println("Error occured" + e.getMessage());
            throw e;
        }
        finally {
            System.out.println("Exiting out of getAvengers method");
        }

    }

    public int addAvenger(Avenger avenger) {
        //create a new instance of MapSqlParameterSource for our use
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "INSERT INTO avengers (name, age) VALUES (:name, :age)";

        // add the parameters to our map
        namedParameters
                .addValue("name",avenger.getName())
                .addValue("age",avenger.getAge());

        int returnValue = jdbc.update(query, namedParameters);
        return returnValue;
    }


    public int deleteAvenger(Long id){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "DELETE FROM avengers WHERE id = :myId";

        namedParameters.addValue("myId", id);

        int returnValue = jdbc.update(query, namedParameters);

        return returnValue;
    }

    public Avenger getAvenger(long id){

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        String query = "SELECT * FROM avengers WHERE id = :id";

        parameters.addValue("id", id);

        BeanPropertyRowMapper<Avenger> mapper = new BeanPropertyRowMapper<>(Avenger.class);

        Avenger avenger = null;

        try {
            avenger = jdbc.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException ex){
            System.out.println("Avenger not forund for id=" + id);
        }
        return avenger;
    }


    public int updateAvenger(Avenger avenger){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "UPDATE avengers SET name = :name, age = :age " + "WHERE id = :id";

        System.out.println("user object from model: " + avenger.getId());

        namedParameters
                .addValue("name", avenger.getName())
                .addValue("age", avenger.getAge())
                .addValue("id", avenger.getId());

        int returnValue = jdbc.update(query, namedParameters);
        return returnValue;

    }


}
