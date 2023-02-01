package com.library.microlibrary.dao.countryDao;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CountryEntity;

import java.util.List;

public interface CountryDao {
    public CountryEntity findCountryByIdDao(Integer countryId);
    public List<CountryEntity> findCountryListDao();
    public void createCountryDao(CreateCountryDto countryDto);
    public void editCountryDao(EditCountryDto countryDto);
}
