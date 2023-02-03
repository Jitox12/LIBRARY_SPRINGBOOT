package com.library.microlibrary.dto.cityDto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCityDto {

    private String cityNameDto;
    private Integer countryIdDto;
}
