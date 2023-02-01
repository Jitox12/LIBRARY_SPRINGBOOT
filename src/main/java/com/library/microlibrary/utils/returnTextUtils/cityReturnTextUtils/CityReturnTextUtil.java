package com.library.microlibrary.utils.returnTextUtils.cityReturnTextUtils;

import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;

public class CityReturnTextUtil {

    public static String createCountryText(GetCityDto savedCityDto, GetCountryDto countryNameDto){
        String returnText = null;

        returnText = ("***Created a new City*** \n" +
                "\n   City Name: ").concat(savedCityDto.getCityName()) +
                "\n   City Id: ".concat(String.valueOf(savedCityDto.getCityId()));
                "\n   Country Name: ".concat(String.valueOf(countryNameDto.getCountryNameDto()));
        return returnText;
    }

    public static String editCountryText(GetCityDto editedCityDto, GetCountryDto countryDto){
        String returnText = null;

        returnText = ("***Edited City with Id: ".concat(String.valueOf(editedCityDto.getCityId()) +"***") +
                "\n*Edited City Name: ".concat(String.valueOf(editedCityDto.getCityName())+"*"));
                "\n*Edited Country Name: ".concat(String.valueOf(countryDto.getCountryNameDto()));

        return returnText;
    }
}