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
public class GABookDto {
    private Integer bookIdDto;
    private String bookNameDto;
    private String categoryNameDto;
    private List<String> authorNameDto;
}
