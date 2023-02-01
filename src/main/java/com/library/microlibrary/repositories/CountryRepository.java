package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {


    List<CountryEntity> findAll();
    CountryEntity findCountryNameByCountryId(Integer countryId);
    CountryEntity save(CountryEntity countryEntity);
}
