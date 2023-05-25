package com.ua.robot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDto {

    private Long id;
    private String city_name;
    private float city_area;
    private Long city_population;

    private String countryName;

}
