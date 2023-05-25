package com.ua.robot.service;

import com.ua.robot.domain.City;
import com.ua.robot.dto.CityDto;
import com.ua.robot.repository.CityRepository;
import com.ua.robot.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public List<CityDto> findAll() {
        return cityRepository.findAll().stream()
                .map(CityService::buildCityDto)
                .collect(Collectors.toList());
    }

    private static CityDto buildCityDto(City city) {
        var countryName = "NO COUNTRY";
        if (city.getCountry() != null) {
            countryName = city.getCountry().getCountry_name();
        }

        return CityDto.builder()
                .id(city.getId())
                .city_name(city.getCity_name())
                .city_area(city.getCity_area())
                .city_population(city.getCity_population())
                .countryName(countryName)
                .build();
    }

    public void save (City city) {
        cityRepository.save(city);
    }

    public void addCountry(Long cityId, Long countryId) {
        var country = countryRepository.findById(countryId).get();
        var city = cityRepository.findById(cityId).get();
        city.setCountry(country);
        cityRepository.save(city);
    }

}
