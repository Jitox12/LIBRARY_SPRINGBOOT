package com.library.microlibrary.utils.returnTextUtils.libraryTextUtils;

import com.library.microlibrary.dto.editorialDto.GetEditorialDto;
import com.library.microlibrary.dto.libraryDto.GetLibraryDto;

public class LibraryReturnTextUtil {

    public static String createLibraryText(GetLibraryDto libraryDto){
        String returnText = null;

        returnText = ("***Created a new Library*** \n" +
                "\n   Library Id: ").concat(String.valueOf(libraryDto.getLibraryIdDto())) +
                "\n   Library Name: ".concat(libraryDto.getLibraryNameDto())+
                "\n   Library City: ".concat(String.valueOf(libraryDto.getCityNameDto()));
        return returnText;
    }

    public static String editLibraryText(GetLibraryDto libraryDto){
        String returnText = null;

        returnText = ("***Edited Library with Id: ".concat(String.valueOf(libraryDto.getLibraryIdDto()) +"***") +
                "\n*Edited Library Name: ".concat(String.valueOf(libraryDto.getLibraryIdDto())+"*"))+
                "\n*Edited Library City: ".concat(String.valueOf(libraryDto.getCityNameDto())+"*");

        return returnText;
    }
}
