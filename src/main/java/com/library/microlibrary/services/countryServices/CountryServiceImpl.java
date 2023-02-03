package com.library.microlibrary.services.countryServices;

import com.library.microlibrary.dao.cityDao.CityDao;
import com.library.microlibrary.dao.cityDao.CityDaoImpl;
import com.library.microlibrary.dao.countryDao.CountryDao;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.exceptionsConfig.exceptions.BadRequestException;
import com.library.microlibrary.mappers.cityMappers.CityEntityToGetCityDtoMapper;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryDtoMapper;
import com.library.microlibrary.mappers.countryMappers.CountryEntityToGetCountryNameDtoMapper;
import com.library.microlibrary.utils.returnTextUtils.countryReturnTextUtils.CountryReturnTextUtil;
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
    private final CityDao cityDao;

    //Mapper's
    private final CountryEntityToGetCountryNameDtoMapper getCountryNameDtoMapper;
    private final CountryEntityToGetCountryDtoMapper getCountryMapper;

    private  final CityEntityToGetCityDtoMapper cityEntityToGetCityDtoMapper;

    @Override
    public GetCountryNameDto findCountryNameByIdService(Integer countryId) {
        CountryEntity country = null;
        GetCountryNameDto countryNameDto = null;

        try {
            country = countryDao.findCountryNameByIdDao(countryId);

            if (Objects.isNull(country)) {
                throw new BadRequestException("Country is null");
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

            returnText = CountryReturnTextUtil.createCountryText(savedCountryDto);

            return returnText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String editCountryService(EditCountryDto countryDto, Integer countryId) {
        //New Country
        GetCountryDto editedCountryDto = null;
        CountryEntity editedCountry = null;

        //Return Controller Format
        String returnText = null;

        //Set param's
        countryDto.setCountryIdDto(countryId);

        try {
            editedCountry = countryDao.editCountryDao(countryDto);
            editedCountryDto = getCountryMapper.countryEntityToGetCountryDto(editedCountry);

            returnText = CountryReturnTextUtil.editCountryText(editedCountryDto);
            return returnText;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


}