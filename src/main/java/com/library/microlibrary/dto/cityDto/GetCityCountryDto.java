package com.library.microlibrary.dto.cityDto;

import com.library.microlibrary.entities.CountryEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCityCountryDto {
    private Integer cityIdDto;
    private String cityNameDto;
    private CountryEntity countryDto;
}
