package com.ua.robot.service;

import com.ua.robot.domain.City;
import com.ua.robot.domain.Country;
import com.ua.robot.dto.CountryDto;
import com.ua.robot.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CountryService {

    private final CountryRepository countryRepository;

    public void save(Country country) {
        countryRepository.save(country);
    }

    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(CountryService::buildCountryDto)
                .collect(Collectors.toList());
    }

    private static CountryDto buildCountryDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .country_name(country.getCountry_name())
                .citiesName(country.getCities().stream()
                        .map(City::getCity_name)
                        .collect(Collectors.toList()))
                .build();
    }
}