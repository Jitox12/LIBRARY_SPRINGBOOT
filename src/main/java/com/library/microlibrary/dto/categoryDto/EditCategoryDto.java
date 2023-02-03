package com.library.microlibrary.dto.categoryDto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EditCategoryDto {
    private Integer categoryIdDto;
    private String categoryNameDto;
}
