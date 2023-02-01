package com.library.microlibrary.dao.countryDao;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.repositories.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Component
public class CountryDaoImpl implements CountryDao {

    private final CountryRepository countryRepository;

    @Override
    public CountryEntity findCountryNameByIdDao(Integer countryId) throws IOException {
        CountryEntity country = null;
        country = countryRepository.findCountryNameByCountryId(countryId);
        return country;
    }

    @Override
    public List<CountryEntity> findCountryNameListDao() throws IOException {
        List<CountryEntity> countryList = null;
        countryList = countryRepository.findAll();
        return countryList;
    }

    @Override
    public CountryEntity findCountryByIdDao(Integer countryId) throws IOException {
        CountryEntity country = null;
        country = countryRepository.findByCountryId(countryId);

        return country;
    }

    @Override
    public CountryEntity createCountryDao(CreateCountryDto countryDto) throws IOException {
        CountryEntity savedCountry = null;

       CountryEntity country = CountryEntity.builder()
               .countryName(countryDto.getCountryNameDto())
               .build();
       savedCountry = countryRepository.save(country);

       return savedCountry;
    }

    @Override
    public CountryEntity editCountryDao(EditCountryDto countryDto) throws IOException {
        CountryEntity editCountry = null;

        CountryEntity country = CountryEntity.builder()
                .countryId(countryDto.getCountryIdDto())
                .countryName(countryDto.getCountryNameDto())
                .build();

        editCountry = countryRepository.save(country);

        return editCountry;
    }
}
