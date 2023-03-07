package com.library.microlibrary.dto.authorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAuthorDto {
    private String authorNameDto;
    private String cityNameDto;
}
