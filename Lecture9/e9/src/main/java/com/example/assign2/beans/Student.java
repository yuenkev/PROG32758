package com.example.assign2.beans;

import lombok.Data;

@Data
public class Student {

    private String fName;
    private String lName;
    private String program;
    private int sYear;
    private String opts;
    private Long id;

    private final String[] programs = {"Science", "Technology", "Engineering" };

}
