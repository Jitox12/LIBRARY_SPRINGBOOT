package com.library.microlibrary.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBookDto {
    private Integer bookIdDto;
    private String bookNameDto;
    private String bookDescriptionDto;
    private String bookIsbnDto;
    private String categoryNameDto;
    private Integer categoryIdDto;
    private List<String> authorNameDto;
    private List<Integer> authorIdDto;
}