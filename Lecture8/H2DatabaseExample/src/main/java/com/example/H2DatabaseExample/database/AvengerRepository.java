package com.example.H2DatabaseExample.database;

import com.example.H2DatabaseExample.beans.Avenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvengerRepository extends CrudRepository<Avenger, Long> {

    Avenger save(Avenger avenger);
    void deleteById(Long id);

    List<Avenger> findAll();
}
