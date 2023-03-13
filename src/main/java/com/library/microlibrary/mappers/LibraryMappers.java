package com.library.microlibrary.mappers;

import com.library.microlibrary.dto.libraryDto.GetLibraryDto;
import com.library.microlibrary.entities.CityEntity;
import com.library.microlibrary.entities.CountryEntity;
import com.library.microlibrary.entities.LibraryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibraryMappers {

    LibraryMappers INSTANCE = Mappers.getMapper(LibraryMappers.class);

    default String CitytoCityName(CityEntity city) {
        return city.getCityName();
    }

    default String CountrytoCountryName(CountryEntity country) {
        return country.getCountryName();
    }

    @Mapping(source = "libraryId", target = "libraryIdDto")
    @Mapping(source = "libraryName", target = "libraryNameDto")
    @Mapping(source = "city", target = "cityNameDto")
    @Mapping(source = "city.country", target = "countryNameDto")
    GetLibraryDto libraryEntityToGetLibraryDto(LibraryEntity library);
}
