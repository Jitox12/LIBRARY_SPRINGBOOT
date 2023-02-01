package com.library.microlibrary.dto.countryDto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EditCountryDto {
    private Integer countryIdDto;
    private String countryNameDto;
}
