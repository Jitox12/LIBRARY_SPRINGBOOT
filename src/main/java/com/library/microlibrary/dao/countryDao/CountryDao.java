package com.library.microlibrary.dao.countryDao;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.entities.CountryEntity;

import java.io.IOException;
import java.util.List;

public interface CountryDao {
    public CountryEntity findCountryByIdDao(Integer countryId) throws IOException;

    public List<CountryEntity> findCountryListDao() throws IOException;

    public CountryEntity createCountryDao(CreateCountryDto countryDto) throws IOException;

    public void editCountryDao(EditCountryDto countryDto) throws IOException;
}
