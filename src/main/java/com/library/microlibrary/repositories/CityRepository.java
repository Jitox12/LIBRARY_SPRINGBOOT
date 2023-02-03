package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.AuthorEntity;
import com.library.microlibrary.entities.BookEntity;
import com.library.microlibrary.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {

    List<CityEntity> findAll();
    CityEntity findCityNameByCityId(Integer cityId);
    CityEntity findByCityId(Integer cityId);
    CityEntity save(CityEntity city);
}
