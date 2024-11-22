package com.spacetravel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(length = 10, nullable = false)
    private String id;

    @Column(nullable = false, length = 500)
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return "";
    }

    public Long getId() {
        return 0L;
    }


}