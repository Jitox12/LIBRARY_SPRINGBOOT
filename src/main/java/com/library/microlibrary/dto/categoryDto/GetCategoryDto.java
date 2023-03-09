package com.library.microlibrary.dto.categoryDto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCategoryDto {
    private Integer categoryIdDto;
    private String categoryNameDto;
}
