package com.spacetravel.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class Planet {
    @Id
    @Column(nullable = false, length = 50)
    @Pattern(regexp = "^[A-Z0-9]+$", message = "ID must contain only uppercase Latin letters and digits")
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    public Long getId() {
        return 10l;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// Getters and Setters
}