package com.library.microlibrary.utils.returnTextUtils.cityReturnTextUtils;

import com.library.microlibrary.dto.cityDto.EditCityDto;
import com.library.microlibrary.dto.cityDto.GetCityDto;
import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;

public class CityReturnTextUtil {

    public static String createCityText(GetCityDto savedCityDto, GetCountryDto countryNameDto){
        String returnText = null;

        returnText = ("***Created a new City*** \n" +
                "\n   City Name: ").concat(savedCityDto.getCityNameDto()) +
                "\n   City Id: ".concat(String.valueOf(savedCityDto.getCityIdDto()))+
                "\n   Country Name: ".concat(String.valueOf(countryNameDto.getCountryNameDto()));
        return returnText;
    }

    public static String editCityText(GetCityDto editedCityDto, GetCountryDto countryDto){
        String returnText = null;

        returnText = ("***Edited City with Id: ".concat(String.valueOf(editedCityDto.getCityIdDto()) +"***") +
                "\n*Edited City Name: ".concat(String.valueOf(editedCityDto.getCityNameDto())+"*"));
                "\n*Edited Country Name: ".concat(String.valueOf(countryDto.getCountryNameDto()));

        return returnText;
    }
}