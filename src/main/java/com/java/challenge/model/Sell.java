package com.java.challenge.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private LocalDate date;

    private Long boothId;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private Package pack;

}
