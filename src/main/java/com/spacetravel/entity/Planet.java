package com.spacetravel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, nullable = false)
    private Long id;

    @Column(nullable = false, length = 500)
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }


}