package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String country_name;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
}
