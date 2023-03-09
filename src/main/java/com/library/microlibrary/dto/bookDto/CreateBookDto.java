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
public class CreateBookDto {
    private String bookNameDto;
    private String bookDescriptionDto;
    private String bookIsbnDto;
    private Integer categoryIdDto;
    private List<Integer> authorIdListDto;
}
