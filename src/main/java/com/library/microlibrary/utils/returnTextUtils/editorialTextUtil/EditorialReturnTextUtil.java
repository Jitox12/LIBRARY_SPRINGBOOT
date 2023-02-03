package com.library.microlibrary.utils.returnTextUtils.editorialTextUtil;

import com.library.microlibrary.dto.countryDto.GetCountryDto;
import com.library.microlibrary.dto.editorialDto.GetEditorialDto;

public class EditorialReturnTextUtil {
    public static String createCountryText(GetEditorialDto editorialDto){
        String returnText = null;

        returnText = ("***Created a new Editorial*** \n" +
                "\n   Editorial Id: ").concat(String.valueOf(editorialDto.getEditorialIdDto())) +
                "\n   Editorial Name: ".concat(editorialDto.getEditorialNameDto());
                "\n   Editorial City: ".concat(String.valueOf(editorialDto.getCityNameDto()));
        return returnText;
    }

    public static String editCountryText(GetEditorialDto editorialDto){
        String returnText = null;

        returnText = ("***Edited Editorial with Id: ".concat(String.valueOf(editorialDto.getEditorialIdDto()) +"***") +
                "\n*Edited Editorial Name: ".concat(String.valueOf(editorialDto.getEditorialNameDto())+"*"))+
                "\n*Edited Editorial City: ".concat(String.valueOf(editorialDto.getCityNameDto())+"*");

        return returnText;
    }
}
