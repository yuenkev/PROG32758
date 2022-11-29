package com.example.H2DatabaseExample.beans;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Table(name="AVENGERS")
public class Avenger {


    private String name;
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private final String[] powerSources = {"Magic", "Technology", "Deity", "Training"};
}
