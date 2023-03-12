package com.library.microlibrary.dto.authorDto;

import com.library.microlibrary.entities.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAuthorCityDto {
    private Integer authorIdDto;
    private String authorNameDto;
    private CityEntity cityDto;
}
