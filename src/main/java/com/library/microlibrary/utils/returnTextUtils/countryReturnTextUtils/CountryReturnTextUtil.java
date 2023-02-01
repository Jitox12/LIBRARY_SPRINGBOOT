package com.library.microlibrary.utils.returnTextUtils.countryReturnTextUtils;

import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.countryDto.GetCountryNameDto;

public class CountryReturnTextUtil {

    public static String createCountryText(GetCountryDto countryDto){
        String returnText = null;

        returnText = ("***Created a new Country*** \n" +
                "\n   Country Name: ").concat(countryDto.getCountryNameDto()) +
                "\n   Country Id: ".concat(String.valueOf(countryDto.getCountryIdDto()));
        return returnText;
    }

    public static String editCountryText(GetCountryDto editedCountryDto ){
        String returnText = null;

        returnText = ("***Edited Country with Id: ".concat(String.valueOf(editedCountryDto.getCountryIdDto()) +"***") +
                "\n*Edited Country Name: ".concat(String.valueOf(editedCountryDto.getCountryNameDto())+"*"));

        return returnText;
    }
}