package com.library.microlibrary.services.countryServices;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.entities.CountryEntity;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    @Override
    public CountryEntity findCountryByIdService(Integer countryId) {
        return null;
    }

    @Override
    public List<CountryEntity> findCountryListService() {
        return null;
    }

    @Override
    public void createCountryService(CreateCountryDto countryDto) {

    }

    @Override
    public void editCountryService(EditCountryDto countryDto, Integer countryId) {

    }
}
