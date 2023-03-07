package com.library.microlibrary.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditBookDto {
    private Integer bookIdDto;
    private String bookNameDto;
    private String bookDescriptionDto;
    private String bookIsbnDto;
    private Integer categoryIdDto;
}
