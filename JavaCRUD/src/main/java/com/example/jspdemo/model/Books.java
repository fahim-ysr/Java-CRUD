// Importing required modules and packages

package com.example.jspdemo.model;

import jakarta.persistence.*;

// Marks this class as a database table
@Entity
// Assigns table name in the database
@Table(name = "BOOKS")

public class Books {

    //    Declaring variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int year;

    //    Constructor function
    public Books() {

    }

    //    Gets the id
    public Long getId() {
        return id;
    }

    //    Sets the id
    public void setId() {
        this.id = id;
    }

    //    Gets the name
    public String getName() {
        return name;
    }

    //    Sets the name
    public void setName(String name) {
        this.name = name;
    }
}