package com.library.microlibrary.dto.cityDto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCityDto {

    private Integer cityIdDto;
    private String cityNameDto;
    private Integer countryIdDto;
}
