package com.library.microlibrary.services.countryServices;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.entities.CountryEntity;

import java.util.List;

public interface CountryService {

    public CountryEntity findCountryByIdService(Integer countryId);
    public List<CountryEntity> findCountryListService();
    public void createCountryService(CreateCountryDto countryDto);
    public void editCountryService(EditCountryDto countryDto, Integer countryId);
}
