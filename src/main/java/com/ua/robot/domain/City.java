package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String city_name;
    @Column
    private float city_area;
    @Column
    private Long city_population;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
