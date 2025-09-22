package com.example.testspringcommunity.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table
@Getter
@Setter
public class Frog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private String Name;
    @Column
    private String Description;
    @Column
    private LocalDate Birthday;

    public Frog() {}
}
