package com.library.microlibrary.dto.bookDto;

import com.library.microlibrary.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBookDto {
    private Integer bookIdDto;
    private String bookNameDto;
    private String bookDescriptionDto;
    private String bookIsbnDto;
    private CategoryEntity categoryDto;
}
