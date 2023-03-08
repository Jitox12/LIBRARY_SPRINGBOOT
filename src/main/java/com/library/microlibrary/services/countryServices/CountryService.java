package com.library.microlibrary.services.countryServices;

import com.library.microlibrary.dto.countryDto.CreateCountryDto;
import com.library.microlibrary.dto.countryDto.EditCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;
import com.library.microlibrary.entities.CountryEntity;

import java.util.List;

public interface CountryService {

    public GetCountryNameDto findCountryNameByIdService(Integer countryId);
    public List<GetCountryNameDto> findCountryNameListService();

    public GetCountryDto findCountryByIdService(Integer countryId);
    public List<GetCountryDto> findCountryListService();

    public void createCountryService(CreateCountryDto countryDto);
    public void editCountryService(EditCountryDto countryDto, Integer countryId);
}
