package com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
