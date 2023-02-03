package com.library.microlibrary.dto.editorialDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEditorialDto {
    private Integer editorialIdDto;
    private String editorialNameDto;
    private String cityNameDto;
    private String countryNameDto;
}
