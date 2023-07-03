package com.java.challenge.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

}
