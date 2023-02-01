package com.library.microlibrary.dao.countryDao;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component
public class CountryDaoImpl implements CountryDao{

    private final CountryRepository countryRepository;

    @Override
    public CountryEntity findCountryByIdDao(Integer countryId) {
        return null;
    }

    @Override
    public List<CountryEntity> findCountryListDao() {
        return null;
    }

    @Override
    public void createCountryDao(CreateCountryDto countryDto) {

    }

    @Override
    public void editCountryDao(EditCountryDto countryDto) {

    }
}
