package ru.mirea.Shutko.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table(name = "tournament")

public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "prize")
    private int prize;

    @Column(name = "teams")
    private ArrayList<String> teams;
}
