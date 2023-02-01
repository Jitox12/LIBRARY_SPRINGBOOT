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
    public CountryEntity findCountryByIdDao(Integer countryId) throws IOException {
        CountryEntity country = countryRepository.findCountryNameByCountryId(countryId);
        return country;
    }

    @Override
    public List<CountryEntity> findCountryListDao() throws IOException {
        List<CountryEntity> countryList = countryRepository.findAll();
        return countryList;
    }

    @Override
    public CountryEntity createCountryDao(CreateCountryDto countryDto) throws IOException {
       CountryEntity country = CountryEntity.builder()
               .countryName(countryDto.getCountryNameDto())
               .build();
       CountryEntity savedCountry = countryRepository.save(country);

       return savedCountry;
    }

    @Override
    public void editCountryDao(EditCountryDto countryDto) throws IOException {
        CountryEntity country = CountryEntity.builder()
                .countryId(countryDto.getCountryIdDto())
                .countryName(countryDto.getCountryNameDto())
                .build();

        countryRepository.save(country);

    }
}
