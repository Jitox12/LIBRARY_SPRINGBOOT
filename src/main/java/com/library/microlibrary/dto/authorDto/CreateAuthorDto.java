package com.library.microlibrary.dto.authorDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorDto {
    private String authorNameDto;
    private Integer cityIdDto;
}
