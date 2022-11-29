package com.example.H2DatabaseExample.beans;

import lombok.Data;

@Data
public class Avenger {

    private String name;
    private int age;
    private Long id;

    private final String[] powerSources = {"Magic", "Technology", "Deity", "Training"};
}
