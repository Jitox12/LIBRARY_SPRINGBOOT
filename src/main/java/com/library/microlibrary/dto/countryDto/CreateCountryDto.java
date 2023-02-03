package com.library.microlibrary.dto.countryDto;


import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCountryDto {
    private String countryNameDto;
    private List<Integer> cityIdDto;
}
