package com.java.challenge.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Booth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
