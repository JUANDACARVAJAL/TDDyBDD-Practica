package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    private boolean completed = false;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

}

