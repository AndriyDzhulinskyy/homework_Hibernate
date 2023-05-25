package com.ua.robot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ua.robot.domain.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}