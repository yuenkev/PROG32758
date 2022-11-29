package com.example.assign2.database;

import com.example.assign2.beans.Student;
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

    public List<Student> getStudents(){
        //here we aren't really doing anything with it now
        MapSqlParameterSource namedParameters=new MapSqlParameterSource();
        String query = "SELECT * FROM students";

        //Uncomment these lines to see the named parameters in action
        query = "SELECT * FROM students";
        namedParameters.addValue("minAge",26); //play around with different numbers
        //Will map a row coming in to an instance of Avenger
        BeanPropertyRowMapper<Student> studentMapper = new BeanPropertyRowMapper<Student>(Student.class);
        //Now that we prepared the helper objects,
        //this one call does it all
        List<Student> students=jdbc.query(query,namedParameters,studentMapper);
        return students;
    }

    public int addStudent(Student students) {
        //create a new instance of MapSqlParameterSource for our use
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "INSERT INTO students (fname, lname, program, sYear, opts) VALUES " +
                "(:fName, :lName, :program, :sYear, :opts)";

        // add the parameters to our map
        namedParameters
                .addValue("fName", students.getFName())
                .addValue("lName", students.getLName())
                .addValue("program", students.getProgram())
                .addValue("sYear", students.getSYear())
                .addValue("opts", students.getOpts());

        int returnValue = jdbc.update(query, namedParameters);
        return returnValue;
    }


    public int deleteStudent(Long id){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "DELETE FROM students WHERE id = :myId";

        namedParameters.addValue("myId", id);

        int returnValue = jdbc.update(query, namedParameters);

        return returnValue;
    }


    public int deleteAll(){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "DELETE FROM students";

//        namedParameters.addValue("myId", id);

        int returnValue = jdbc.update(query, namedParameters);

        return returnValue;
    }

    public Student getStudents(long id){

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        String query = "SELECT * FROM students WHERE id = :id";

        parameters.addValue("id", id);

        BeanPropertyRowMapper<Student> mapper = new BeanPropertyRowMapper<>(Student.class);

        Student student = null;

        try {
            student = jdbc.queryForObject(query, parameters, mapper);
        } catch (EmptyResultDataAccessException ex){
            System.out.println("User not found for id=" + id);
        }
        return student;
    }


    public int updateStudent(Student student){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "UPDATE students SET id = :id, fName = :fName, lName = :lName, program = :program, sYear = :sYear," +
                "opts =:opts" +
                " WHERE id = :id";

        System.out.println("student object from model: " + student.getId());

        namedParameters
                .addValue("fName", student.getFName())
                .addValue("lName", student.getLName())
                .addValue("program", student.getProgram())
                .addValue("sYear", student.getSYear())
                .addValue("opts", student.getOpts())
                .addValue("id", student.getId());


        int returnValue = jdbc.update(query, namedParameters);
        return returnValue;

    }


}
