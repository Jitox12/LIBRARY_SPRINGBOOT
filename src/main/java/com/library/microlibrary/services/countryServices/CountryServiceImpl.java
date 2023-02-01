package com.library.microlibrary.services.countryServices;

import com.library.microlibrary.dao.countryDao.CountryDao;
import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryDto;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryNameDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    //Dao's
    private final CountryDao countryDao;

    //Mapper's
    private final CountryEntityToGetCountryNameDto getCountryNameDtoMapper;
    private final CountryEntityToGetCountryDto getCountryMapper;
    
    @Override
    public GetCountryNameDto findCountryNameByIdService(Integer countryId) {
        CountryEntity country = null;
        GetCountryNameDto countryNameDto = null;

        try {
            country = countryDao.findCountryByIdDao(countryId);

            if (Objects.isNull(country)) {
                throw new BadRequestException("contry is null");
            }

            countryNameDto = getCountryNameDtoMapper.countryEntityToGetCountryNameDto(country);
            return countryNameDto;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GetCountryNameDto> findCountryNameListService() {
        List<CountryEntity> country = null;
        List<GetCountryNameDto> countryNameDto = null;

        try {
            country = countryDao.findCountryListDao();
            countryNameDto = country.stream().map(getCountryNameDtoMapper::countryEntityToGetCountryNameDto).collect(Collectors.toList());
            return countryNameDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GetCountryDto findCountryByIdService(Integer countryId) {
        return null;
    }

    @Override
    public List<GetCountryDto> findCountryListService() {
        return null;
    }

    @Override
    public String createCountryService(CreateCountryDto countryDto) {
        CountryEntity country = null;
        GetCountryDto savedCountryDto = null;
        String returnText = null;

        try {
            country = countryDao.createCountryDao(countryDto);
            savedCountryDto = getCountryMapper.countryEntityToGetCountryDto(country);

            returnText = ("***Created a new Country*** \n" +
                    "\n   Country Name: ").concat(savedCountryDto.getCountryNameDto()) +
                    "\n   Country Id: ".concat(String.valueOf(savedCountryDto.getCountryIdDto()));

            return returnText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editCountryService(EditCountryDto countryDto, Integer countryId) {

    }
}