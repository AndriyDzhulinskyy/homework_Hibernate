package com.ua.robot.rest;

import com.ua.robot.domain.City;
import com.ua.robot.dto.CityDto;
import com.ua.robot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CityController {

    private final CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> findAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    @PostMapping("/cities")
    public ResponseEntity<Void> save(@RequestBody City city) {
        cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/cities/{cityId}/countries/{countryId}")
    public ResponseEntity<Void> update(@PathVariable Long cityId, @PathVariable Long countryId) {
        cityService.addCountry(cityId, countryId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
