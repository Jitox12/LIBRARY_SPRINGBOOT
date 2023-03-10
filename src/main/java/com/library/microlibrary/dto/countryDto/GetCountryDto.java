package com.library.microlibrary.dto.countryDto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCountryDto {
    private Integer countryIdDto;
    private String countryNameDto;
}
