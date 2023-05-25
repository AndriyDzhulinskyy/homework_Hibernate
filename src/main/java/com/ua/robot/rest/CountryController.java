package com.ua.robot.rest;

import com.ua.robot.domain.Country;
import com.ua.robot.dto.CountryDto;
import com.ua.robot.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CountryController {

    private final CountryService countryService;

    @PostMapping("/countries")
    public void save (@RequestBody Country country) {
        countryService.save(country);
    }

    @GetMapping("/countries")
    public List<CountryDto> findAll() {
        return countryService.findAll();
    }

}
